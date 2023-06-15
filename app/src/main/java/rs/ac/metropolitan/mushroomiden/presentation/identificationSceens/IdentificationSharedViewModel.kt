package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens

import android.content.ContentResolver
import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rs.ac.metropolitan.mushroomiden.common.Resource
import rs.ac.metropolitan.mushroomiden.common.util.HeatMapUrlBuilder
import rs.ac.metropolitan.mushroomiden.common.util.ImageConverter
import rs.ac.metropolitan.mushroomiden.data.remote.dto.IdentificationRequest
import rs.ac.metropolitan.mushroomiden.data.remote.dto.Suggestion
import rs.ac.metropolitan.mushroomiden.domain.use_case.get_identification.GetIdentificationUseCase
import javax.inject.Inject

@HiltViewModel
class IdentificationSharedViewModel @Inject constructor(private val getIdentificationUseCase: GetIdentificationUseCase) :ViewModel(){


    private val _state = mutableStateOf(IdentificationResultState())
    val state: State<IdentificationResultState> = _state


    private val _suggestionDetails = mutableStateOf(Suggestion())
    val suggestionDetails: State<Suggestion> = _suggestionDetails


    private val _selectedImageUris = MutableStateFlow<List<Uri>>(emptyList())
    val selectedImageUris: StateFlow<List<Uri>> = _selectedImageUris.asStateFlow()

    private val _base64Strings = MutableStateFlow<List<String>>(emptyList())

    fun setSelectedImageUris(uris: List<Uri>) {
        _selectedImageUris.value = uris
    }

    fun setSelectedSuggestion(suggestion: Suggestion) {
        _suggestionDetails.value = suggestion
    }

    fun convertUrisToBase64(contentResolver: ContentResolver){
        val base64Images = mutableListOf<String>()
        for (uri in selectedImageUris.value) {
            val base64 = ImageConverter.convertUriToBase64(contentResolver, uri)
            base64Images.add(base64)
        }
        _base64Strings.value = base64Images
        val ir = IdentificationRequest(base64Images,0.0,0.0,true)
        getCoins(ir)
    }

    fun getRightHeatMapImageUrl():String{
        return HeatMapUrlBuilder.getUrlForRightHeatImage(suggestionDetails.value.details!!.gbif_id)
    }

    fun getLeftHeatMapImageUrl():String{
        return HeatMapUrlBuilder.getUrlForLeftHeatImage(suggestionDetails.value.details!!.gbif_id)
    }

    private fun getCoins(identificationRequest: IdentificationRequest) {
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


}