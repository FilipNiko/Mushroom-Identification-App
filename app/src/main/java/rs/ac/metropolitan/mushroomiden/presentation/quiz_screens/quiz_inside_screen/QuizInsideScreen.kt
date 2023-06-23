package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_inside_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen


@Composable
fun QuizInsideScreen(
    navController: NavController,
    viewModel: QuizInsideViewModel = hiltViewModel()
) {

    val questionsAndAnswersState = viewModel.allQuestionsAndAnswersState.value

    var currentQuestionIndex = viewModel.currentScoreState.value

    var numberOfQuestions = viewModel.numberOfQuestions.value

    var time = remember {
        System.currentTimeMillis()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 25.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            itemsIndexed(questionsAndAnswersState.questionsAndAnswers) { index, questionAndAnswer ->
                if (index == currentQuestionIndex) {
                    Column(modifier = Modifier.fillMaxSize()) {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Score: ${currentQuestionIndex}",
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 27.sp,
                                fontWeight = FontWeight.ExtraBold,
                                textAlign = TextAlign.Center
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 4.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Which mushroom is this?",
                                color = MaterialTheme.colorScheme.primary,
                                fontSize = 27.sp,
                                fontWeight = FontWeight.ExtraBold,
                                textAlign = TextAlign.Center
                            )
                        }

                        Spacer(modifier = Modifier.height(13.dp))


                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            AsyncImage(
                                model = questionAndAnswer.firstQuestionPicture,
                                contentDescription = null,
                                contentScale = ContentScale.FillWidth,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .shadow(elevation = 20.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 40.dp),
                            verticalAlignment = Alignment.Bottom
                        ) {
                            Button(
                                modifier = Modifier.fillMaxSize(),
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                shape = RoundedCornerShape(9.dp),
                                onClick = {
                                    if (questionAndAnswer.firstAnswer == questionAndAnswer.correctAnswer) {
                                        viewModel.increaseScoreByOne()

                                        if(currentQuestionIndex ==numberOfQuestions){
                                            time = System.currentTimeMillis() - time
                                            navController.popBackStack()
                                            navController.navigate(Screen.QuizWrongAnswerScreen.route + "/${currentQuestionIndex}/${time}/true")
                                        }
                                    }
                                    else {
                                        time = System.currentTimeMillis() - time
                                        navController.popBackStack()
                                        navController.navigate(Screen.QuizWrongAnswerScreen.route + "/${currentQuestionIndex}/${time}/false")
                                    }

                                }) {
                                Text(
                                    text = questionAndAnswer.firstAnswer,
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 11.dp)
                        ) {
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                // .height(40.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                shape = RoundedCornerShape(9.dp),
                                onClick = {
                                    if (questionAndAnswer.secondAnswer == questionAndAnswer.correctAnswer) {
                                        viewModel.increaseScoreByOne()

                                        if(currentQuestionIndex ==numberOfQuestions){
                                            time = System.currentTimeMillis() - time
                                            navController.popBackStack()
                                            navController.navigate(Screen.QuizWrongAnswerScreen.route + "/${currentQuestionIndex}/${time}/true")
                                        }
                                    } else {
                                        time = System.currentTimeMillis() - time
                                        navController.popBackStack()
                                        navController.navigate(Screen.QuizWrongAnswerScreen.route + "/${currentQuestionIndex}/${time}/false")
                                    }
                                }) {
                                Text(
                                    text = questionAndAnswer.secondAnswer,
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 11.dp)
                        ) {
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                shape = RoundedCornerShape(9.dp),
                                onClick = {
                                    if (questionAndAnswer.thirdAnswer == questionAndAnswer.correctAnswer) {
                                        viewModel.increaseScoreByOne()

                                        if(currentQuestionIndex ==numberOfQuestions){
                                            time = System.currentTimeMillis() - time
                                            navController.popBackStack()
                                            navController.navigate(Screen.QuizWrongAnswerScreen.route + "/${currentQuestionIndex}/${time}/true")
                                        }
                                    } else {
                                        time = System.currentTimeMillis() - time
                                        navController.popBackStack()
                                        navController.navigate(Screen.QuizWrongAnswerScreen.route + "/${currentQuestionIndex}/${time}/false")
                                    }
                                }) {
                                Text(
                                    text = questionAndAnswer.thirdAnswer,
                                    textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 11.dp)
                        ) {
                            Button(
                                modifier = Modifier.fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                shape = RoundedCornerShape(9.dp),
                                onClick = {
                                    if (questionAndAnswer.fourthAnswer == questionAndAnswer.correctAnswer) {
                                        viewModel.increaseScoreByOne()

                                        if(currentQuestionIndex ==numberOfQuestions){
                                            time = System.currentTimeMillis() - time
                                            navController.popBackStack()
                                            navController.navigate(Screen.QuizWrongAnswerScreen.route + "/${currentQuestionIndex}/${time}/true")
                                        }
                                    } else {
                                        time = System.currentTimeMillis() - time
                                        navController.popBackStack()
                                        navController.navigate(Screen.QuizWrongAnswerScreen.route + "/${currentQuestionIndex}/${time}/false")
                                    }
                                }){

                                    Text(
                                        text = questionAndAnswer.fourthAnswer,
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colorScheme.primary
                                    )

                                }
                        }
                    }

                }
            }
        }
    }
}