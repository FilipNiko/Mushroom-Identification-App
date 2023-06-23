package rs.ac.metropolitan.mushroomiden.presentation.identification_history_screens

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rs.ac.metropolitan.mushroomiden.domain.use_case.completed_identifications.GetAllCompletedIdentificationsUseCase
import rs.ac.metropolitan.mushroomiden.domain.use_case.get_identification.RetrieveIdentificationUseCase
import javax.inject.Inject

@HiltViewModel
class CompletedIdentificationsHistoryViewModel @Inject constructor(
    private val getAllCompletedIdentificationsUseCase: GetAllCompletedIdentificationsUseCase,
    private val retrieveIdentificationUseCase: RetrieveIdentificationUseCase
) : ViewModel() {

    //Identification result state
    private val _allIdentificationsResultState = mutableStateOf(CompletedIdentificationsState())
    val allIdentificationsResultState: State<CompletedIdentificationsState> = _allIdentificationsResultState

    private var getAllCompletedIdentificationsJob: Job? = null

    init {
        getAllCompletedIdentifications()
    }



    private fun getAllCompletedIdentifications() {
        getAllCompletedIdentificationsJob?.cancel()
        getAllCompletedIdentificationsJob = getAllCompletedIdentificationsUseCase()
            .onEach { completedIdentifications ->
                _allIdentificationsResultState.value = allIdentificationsResultState.value.copy(
                    completedIdentifications = completedIdentifications,
                )
            }
            .launchIn(viewModelScope)
    }

}