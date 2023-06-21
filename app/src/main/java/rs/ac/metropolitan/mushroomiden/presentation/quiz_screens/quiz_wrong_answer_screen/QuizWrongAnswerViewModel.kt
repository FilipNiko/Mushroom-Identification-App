package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_wrong_answer_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import rs.ac.metropolitan.mushroomiden.common.Constants
import javax.inject.Inject

@HiltViewModel
class QuizWrongAnswerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _scoreState = mutableStateOf(0)
    val scoreState : State<Int> = _scoreState


    init {
        savedStateHandle.get<String>(Constants.PARAM_SCORE)?.let { score ->
            _scoreState.value = score.toInt()
        }
    }
}