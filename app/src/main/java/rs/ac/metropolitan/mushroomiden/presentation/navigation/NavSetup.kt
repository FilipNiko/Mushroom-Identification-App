package rs.ac.metropolitan.mushroomiden.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.IdentificationSharedViewModel
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.idrentification_result.IdentificationResultScreen
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification.RequestIdentificationScreen
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.SuggestionDetailsScreen

@Composable
fun NavSetup (navController: NavHostController) {

    val sharedViewModel: IdentificationSharedViewModel = hiltViewModel()

    NavHost(
    navController = navController,
    startDestination = Screen.RequestIdentificationScreen.route
    ) {

        composable(
            route = Screen.RequestIdentificationScreen.route
        ) {
            RequestIdentificationScreen(navController, sharedViewModel)
        }
        composable(
            route = Screen.IdentificationResultScreen.route
        ) {
            IdentificationResultScreen(navController, sharedViewModel)
        }
        composable(
            route = Screen.SuggestionDetailsScreen.route
        ) {
            SuggestionDetailsScreen(navController, sharedViewModel)
        }
    }
}