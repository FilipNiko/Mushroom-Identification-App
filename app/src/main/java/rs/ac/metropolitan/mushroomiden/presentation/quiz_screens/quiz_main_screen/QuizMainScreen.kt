package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_main_screen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.NoPhotography
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import rs.ac.metropolitan.mushroomiden.presentation.identification_history_screens.components.HistoryItemCard
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen
import rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_main_screen.components.StartQuizItemCard


@Composable
fun QuizMainScreen(
    navController: NavController,
    viewModel: QuizMainScreenViewModel = hiltViewModel()
) {


    Box(modifier = Modifier
        .fillMaxSize()
        .padding(horizontal = 25.dp)) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            item {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 4.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Mushroom Identification Quiz",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 27.sp,
                        fontWeight = FontWeight.ExtraBold,
                        textAlign = TextAlign.Center
                    )
                }
                
                Spacer(modifier = Modifier.height(35.dp))
                
                
            StartQuizItemCard {
                navController.navigate(Screen.QuizInsideScreen.route)
            }
            }
        }
    }
}
