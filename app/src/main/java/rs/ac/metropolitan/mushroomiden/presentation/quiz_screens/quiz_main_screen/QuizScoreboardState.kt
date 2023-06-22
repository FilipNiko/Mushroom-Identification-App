package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_main_screen



import rs.ac.metropolitan.mushroomiden.domain.model.QuizScoreEntity


data class QuizScoreboardState(
    val quizScoresList: List<QuizScoreEntity> = emptyList()
)