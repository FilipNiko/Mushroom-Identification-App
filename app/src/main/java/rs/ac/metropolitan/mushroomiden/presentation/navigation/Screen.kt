package rs.ac.metropolitan.mushroomiden.presentation.navigation

sealed class Screen (val route:String){
    object RequestIdentificationScreen: Screen("request_identification_screen")
    object IdentificationResultScreen: Screen("identification_result_screen")
    object SuggestionDetailsScreen: Screen("suggestion_details_screen")
}
