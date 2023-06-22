package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_wrong_answer_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import rs.ac.metropolitan.mushroomiden.common.Constants
import rs.ac.metropolitan.mushroomiden.common.util.MillisecondsConverter.millisecondsToMinutesAndSecondsString
import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity
import rs.ac.metropolitan.mushroomiden.domain.use_case.quiz.scoreboard.InsertNewScoreUseCase
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class QuizWrongAnswerViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val insertNewScoreUseCase: InsertNewScoreUseCase
): ViewModel() {

    private val _scoreState = mutableStateOf(0)
    val scoreState : State<Int> = _scoreState

    private val _quizTimeState = mutableStateOf("00:00")

    private val _isWon = mutableStateOf(false)
    val isWon : State<Boolean> = _isWon

    init {

        viewModelScope.launch {

            savedStateHandle.get<String>(Constants.PARAM_SCORE)?.let { score ->
                _scoreState.value = score.toInt()
            }

            savedStateHandle.get<String>(Constants.ELAPSED_TIME)?.let { time ->
                _quizTimeState.value = millisecondsToMinutesAndSecondsString(time.toLong())
            }

            savedStateHandle.get<String>(Constants.IS_WON)?.let { won ->
                _isWon.value = won.toBoolean()
            }

            insertNewScoreIntoDatabase()
        }

    }




    private suspend fun insertNewScoreIntoDatabase() {
        val dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        val currentDate = LocalDateTime.now().format(dateTimeFormatter)

        val score = QuizScoreEntity(
            id=0,
            gameDate = currentDate,
            elapsedTime = _quizTimeState.value,
            score = _scoreState.value
        )
        insertNewScoreUseCase(score)
    }
}