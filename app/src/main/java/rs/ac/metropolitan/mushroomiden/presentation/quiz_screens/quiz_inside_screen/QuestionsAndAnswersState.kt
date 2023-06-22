package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_inside_screen


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import rs.ac.metropolitan.mushroomiden.domain.model.QuestionsAndAnswersEntity

data class QuestionsAndAnswersState(
    val questionsAndAnswers: List<QuestionsAndAnswersEntity> = emptyList()
){
    var currentQuestionIndex by mutableStateOf(0)
}