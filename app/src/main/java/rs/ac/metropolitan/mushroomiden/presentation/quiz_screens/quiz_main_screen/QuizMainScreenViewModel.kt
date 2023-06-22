package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_main_screen



import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rs.ac.metropolitan.mushroomiden.domain.use_case.quiz.scoreboard.GetAllScoresUseCase
import javax.inject.Inject

@HiltViewModel
class QuizMainScreenViewModel @Inject constructor(
    private val getAllScoresUseCase: GetAllScoresUseCase
) : ViewModel() {


    private val _quizScoreboardState = mutableStateOf(QuizScoreboardState())
    val quizScoreboardState : State<QuizScoreboardState> = _quizScoreboardState

    private var getAllScoresJob: Job? = null


    init{
        getAllScores()
    }


    private fun getAllScores() {
        getAllScoresJob?.cancel()
        getAllScoresJob = getAllScoresUseCase()
            .onEach { scores ->
                _quizScoreboardState.value = quizScoreboardState.value.copy(
                    quizScoresList = scores,
                )
            }
            .launchIn(viewModelScope)
    }

}