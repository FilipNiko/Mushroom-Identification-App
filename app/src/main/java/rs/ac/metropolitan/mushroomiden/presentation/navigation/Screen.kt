package rs.ac.metropolitan.mushroomiden.presentation.navigation

sealed class Screen (val route:String){
    object RequestIdentificationScreen: Screen("request_identification_screen")
    object IdentificationResultScreen: Screen("identification_result_screen")
    object SuggestionDetailsScreen: Screen("suggestion_details_screen")
    object HistoryScreen: Screen("history_screen")
    object QuizScreen: Screen("quiz_screen")
    object QuizInsideScreen: Screen("quiz_inside_screen")
    object QuizWrongAnswerScreen: Screen("quiz_wrong_answer_screen")
}
