package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_inside_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import rs.ac.metropolitan.mushroomiden.domain.use_case.quiz.GetAllQuestionsAndAnswersUseCase
import javax.inject.Inject


@HiltViewModel
class QuizInsideViewModel @Inject constructor(
    private val getAllQuestionsAndAnswersUseCase: GetAllQuestionsAndAnswersUseCase
) : ViewModel() {

    //Questions and answers state
    private val _allQuestionsAndAnswersState = mutableStateOf(QuestionsAndAnswersState())
    val allQuestionsAndAnswersState: State<QuestionsAndAnswersState> = _allQuestionsAndAnswersState


    private var getAllQuestionsAndAnswersJob: Job? = null


    private val _currentScoreState = mutableStateOf(0);
    val currentScoreState: State<Int> = _currentScoreState

    private val _numberOfQuestions = mutableStateOf(0);
    val numberOfQuestions: State<Int> = _numberOfQuestions


    init {
        getAllQuestionsAndAnswers()
    }


    private fun getAllQuestionsAndAnswers() {
        getAllQuestionsAndAnswersJob?.cancel()
        getAllQuestionsAndAnswersJob = getAllQuestionsAndAnswersUseCase()
            .onEach { questionsAndAnswers ->
                _numberOfQuestions.value = questionsAndAnswers.size - 1
                _allQuestionsAndAnswersState.value = allQuestionsAndAnswersState.value.copy(
                    questionsAndAnswers = questionsAndAnswers,
                )
            }
            .launchIn(viewModelScope)
    }


    fun increaseScoreByOne() {
        _currentScoreState.value++
    }

}