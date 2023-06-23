package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_main_screen


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import rs.ac.metropolitan.mushroomiden.R
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen
import rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_main_screen.components.StartQuizItemCard


@Composable
fun QuizMainScreen(
    navController: NavController,
    viewModel: QuizMainScreenViewModel = hiltViewModel()
) {


    val scoresState = viewModel.quizScoreboardState.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp)
    ) {
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

                Spacer(modifier = Modifier.height(60.dp))


                Row(modifier = Modifier.fillMaxWidth()){

                    Text(
                        text = "My previous games",
                        color = MaterialTheme.colorScheme.secondary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold,
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Row(modifier = Modifier.fillMaxWidth()){
                    Divider(color = MaterialTheme.colorScheme.secondary, thickness = 1.5.dp)
                }
                Spacer(modifier = Modifier.height(5.dp))

                if (scoresState.quizScoresList.isNotEmpty()) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding( bottom = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Date                ",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "Time",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "Score",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start
                        )
                    }


                }else{
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top=19.dp)
                            .height(200.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mushroom_thinking_c),
                            contentDescription = "mushroom_thinking",
                            contentScale = ContentScale.FillHeight,
                            modifier = Modifier
                                .fillMaxSize())
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "No previous games",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 19.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }
                }

            }



            if (scoresState.quizScoresList.isNotEmpty()) {

                items(scoresState.quizScoresList) { score ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, bottom = 4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${score.gameDate}",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "${score.elapsedTime}",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start,
                        )
                        Text(
                            text = "${score.score}",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Start
                        )
                    }

                }
            }
        }

    }
}



