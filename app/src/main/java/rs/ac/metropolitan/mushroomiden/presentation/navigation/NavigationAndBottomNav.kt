package rs.ac.metropolitan.mushroomiden.presentation.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.InsertPhoto
import androidx.compose.material.icons.rounded.Quiz
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import rs.ac.metropolitan.mushroomiden.presentation.Greeting3
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.IdentificationSharedViewModel
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.identification_result.IdentificationResultScreen
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification.RequestIdentificationScreen
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.SuggestionDetailsScreen
import rs.ac.metropolitan.mushroomiden.presentation.identification_history_screens.HistoryScreen
import rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_inside_screen.QuizInsideScreen
import rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_main_screen.QuizMainScreen
import rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_wrong_answer_screen.QuizWrongAnswerScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNav() {

    val sharedViewModel: IdentificationSharedViewModel = hiltViewModel()

    val bottomNavItems = listOf(
        BottomNavItem(
            name = "Quiz",
            route = Screen.QuizScreen.route,
            icon = Icons.Rounded.Quiz,
        ),
        BottomNavItem(
            name = "Identification",
            route = Screen.RequestIdentificationScreen.route,
            icon = Icons.Rounded.InsertPhoto,
        ),
        BottomNavItem(
            name = "History",
            route = Screen.HistoryScreen.route,
            icon = Icons.Rounded.History,
        ),
    )

    val navController = rememberNavController()
    var lastTopItemSlected by rememberSaveable{mutableStateOf(Screen.QuizScreen.route)}

    Scaffold(
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ){
                bottomNavItems.forEach { item ->
                    NavigationBarItem(
                        alwaysShowLabel = false,
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.name,
                                tint = if (lastTopItemSlected == item.route)
                                    MaterialTheme.colorScheme.onPrimaryContainer
                                else
                                    MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        label = {
                            Text(
                                text = item.name,
                                color = if (lastTopItemSlected == item.route)
                                    MaterialTheme.colorScheme.onPrimaryContainer
                                else
                                    MaterialTheme.colorScheme.onPrimary,
                                fontWeight = if (lastTopItemSlected == item.route)
                                    FontWeight.Bold
                                else
                                    FontWeight.Normal,
                            )
                        },
                        selected = lastTopItemSlected == item.route,
                        onClick = {
                            navController.popBackStack()
                            navController.navigate(item.route)
                            lastTopItemSlected = item.route
                        }
                    )



                }
            }
        }
    ) {
        NavHost(
            navController,
            startDestination = Screen.QuizScreen.route,
            modifier = Modifier.padding(it)){

            composable(
                route = Screen.QuizScreen.route
            ) {
                QuizMainScreen(navController)
            }

            composable(
                route = Screen.QuizInsideScreen.route
            ) {
                QuizInsideScreen(navController)
            }

            composable(
                route = Screen.QuizWrongAnswerScreen.route + "/{score}"
            ) {
                QuizWrongAnswerScreen(navController)
            }

            composable(
                route = Screen.RequestIdentificationScreen.route
            ) {
                RequestIdentificationScreen(navController, sharedViewModel)
            }

            composable(
                route = Screen.HistoryScreen.route
            ) {
                HistoryScreen(navController)
            }

            composable(
                route = Screen.IdentificationResultScreen.route + "/{accessToken}"
            ) {navBackStackEntry->
                val accessToken = navBackStackEntry.arguments?.getString("accessToken")
                if(accessToken!=null){
                    IdentificationResultScreen(navController, sharedViewModel, accessToken)
                }
            }

            composable(
                route = Screen.SuggestionDetailsScreen.route
            ) {
                SuggestionDetailsScreen(navController, sharedViewModel)
            }

        }
    }
}