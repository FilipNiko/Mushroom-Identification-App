package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens

import android.content.ContentResolver
import android.location.Location
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import rs.ac.metropolitan.mushroomiden.common.Resource
import rs.ac.metropolitan.mushroomiden.common.util.HeatMapUrlBuilder
import rs.ac.metropolitan.mushroomiden.common.util.ImageConverter
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Suggestion
import rs.ac.metropolitan.mushroomiden.domain.location.LocationTracker
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import rs.ac.metropolitan.mushroomiden.domain.use_case.completed_identifications.AddCompletedIdentificationUseCase
import rs.ac.metropolitan.mushroomiden.domain.use_case.get_identification.GetIdentificationUseCase
import rs.ac.metropolitan.mushroomiden.domain.use_case.get_identification.RetrieveIdentificationUseCase
import rs.ac.metropolitan.mushroomiden.domain.use_case.get_location_info.GetLocationResultInfoUseCase
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject


@HiltViewModel
class IdentificationSharedViewModel @Inject constructor(
    private val getIdentificationUseCase: GetIdentificationUseCase,
    private val getLocationResultInfoUseCase: GetLocationResultInfoUseCase,
    private val locationTracker: LocationTracker,
    private val addCompletedIdentificationUseCase: AddCompletedIdentificationUseCase,
    private val retrieveIdentificationUseCase: RetrieveIdentificationUseCase
) : ViewModel() {



    //Uris of images added by user
    private val _selectedImageUris = MutableStateFlow<List<Uri>>(emptyList())
    val selectedImageUris: StateFlow<List<Uri>> = _selectedImageUris.asStateFlow()

    fun setSelectedImageUris(uris: List<Uri>) {
        _selectedImageUris.value = uris
    }

    //Images converted to base64 Strings
    private val _base64Strings = MutableStateFlow<List<String>>(emptyList())


    //Identification result state
    private val _state = mutableStateOf(IdentificationResultState())
    val state: State<IdentificationResultState> = _state

    //Detail location info state
    private val _locationInfoState = mutableStateOf(LocationResultInfoState())
    val locationInfoState: State<LocationResultInfoState> = _locationInfoState


    //Use Location
    private val _useLocationState = mutableStateOf(false)
    val useLocationState: State<Boolean> = _useLocationState

    fun setUseLocation(checked: Boolean) {
        _useLocationState.value = checked
    }


    //Specific identification result details
    private val _suggestionDetails = mutableStateOf(Suggestion())
    val suggestionDetails: State<Suggestion> = _suggestionDetails
    fun setSelectedSuggestion(suggestion: Suggestion) {
        _suggestionDetails.value = suggestion
    }


    //Current location of user
    private val _currentLocation = MutableStateFlow<Location?>(null)


    //Current location methods
    fun getCurrentLocationWithDetails() {
        viewModelScope.launch {
            getCurrentLocation()

            if (_currentLocation.value?.longitude != null && _currentLocation.value?.latitude != null) {
                getLocationResultInfo(
                    _currentLocation.value!!.latitude,
                    _currentLocation.value!!.longitude
                )
            }
        }
    }

    private suspend fun getCurrentLocation() {
        _currentLocation.value = locationTracker.getCurrentLocation()
    }

    private suspend fun getLocationResultInfo(latitude: Double, longitude: Double) {
        getLocationResultInfoUseCase(latitude, longitude).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _locationInfoState.value =
                        LocationResultInfoState(locationResultInfo = result.data)
                }

                is Resource.Error -> {
                    _locationInfoState.value = LocationResultInfoState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }

                is Resource.Loading -> {
                    _locationInfoState.value = LocationResultInfoState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }


    fun getIdentificationResultAndInsertIntoDatabase(contentResolver: ContentResolver) {
        viewModelScope.launch {
            convertUrisToBase64(contentResolver)
            getIdentificationResult()

            delay(3000)
            if (_state.value.identificationResult?.access_token != null) {
                insertCompletedIdentificationInDatabase()
            }
        }
    }


    //Images converter to base64 Strings
    private fun convertUrisToBase64(contentResolver: ContentResolver) {
        val base64Images = mutableListOf<String>()
        for (uri in selectedImageUris.value) {
            val base64 = ImageConverter.convertUriToBase64(contentResolver, uri)
            base64Images.add(base64)
        }
        _base64Strings.value = base64Images
    }

    private suspend fun getIdentificationResult() {

        if (_locationInfoState.value.locationResultInfo?.latitude != null && _locationInfoState.value.locationResultInfo?.longitude != null && useLocationState.value) {
            val ir = IdentificationRequest(
                _base64Strings.value,
                locationInfoState.value.locationResultInfo!!.latitude,
                locationInfoState.value.locationResultInfo!!.longitude,
                true
            )
            getIdentificationResult(ir)
        } else {
            val ir = IdentificationRequest(
                images = _base64Strings.value,
                similar_images = true
            )
            getIdentificationResult(ir)
        }
    }


    private suspend fun getIdentificationResult(identificationRequest: IdentificationRequest) {
        getIdentificationUseCase(identificationRequest).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = IdentificationResultState(identificationResult = result.data)
                }

                is Resource.Error -> {
                    _state.value = IdentificationResultState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }

                is Resource.Loading -> {
                    _state.value = IdentificationResultState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private suspend fun insertCompletedIdentificationInDatabase() {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
        val currentDate = LocalDateTime.now().format(dateTimeFormatter)

        val completedIdentificationEntity = CompletedIdentificationEntity(
            _state.value.identificationResult!!.access_token,
            currentDate,
            _state.value.identificationResult?.input?.latitude,
            _state.value.identificationResult?.input?.longitude,
            _state.value.identificationResult!!.input.images[0],
            _locationInfoState.value.locationResultInfo?.city,
            _locationInfoState.value.locationResultInfo?.countryName,
            _locationInfoState.value.locationResultInfo?.continent,
        )
        addCompletedIdentificationUseCase(completedIdentificationEntity)
    }


    fun getRightHeatMapImageUrl(): String {
        return HeatMapUrlBuilder.getUrlForRightHeatImage(suggestionDetails.value.details!!.gbif_id)
    }

    fun getLeftHeatMapImageUrl(): String {
        return HeatMapUrlBuilder.getUrlForLeftHeatImage(suggestionDetails.value.details!!.gbif_id)
    }


     fun getIdentificationsByAccessToken(accessToken: String){
        if(accessToken!="0"){
            retrieveIdentificationResult(accessToken)
        }
    }

    private fun retrieveIdentificationResult(accessToken: String) {
        retrieveIdentificationUseCase(accessToken).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = IdentificationResultState(identificationResult = result.data)
                }

                is Resource.Error -> {
                    _state.value = IdentificationResultState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }

                is Resource.Loading -> {
                    _state.value = IdentificationResultState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}

