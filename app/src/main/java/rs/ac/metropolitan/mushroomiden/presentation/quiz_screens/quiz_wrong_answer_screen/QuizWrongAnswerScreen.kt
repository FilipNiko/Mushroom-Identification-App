package rs.ac.metropolitan.mushroomiden.presentation.quiz_screens.quiz_wrong_answer_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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

@Composable
fun QuizWrongAnswerScreen(
    navController: NavController,
    viewModel: QuizWrongAnswerViewModel = hiltViewModel()
){

    val score = viewModel.scoreState.value

    val isWon = viewModel.isWon.value

   Column(
       modifier = Modifier
           .fillMaxSize()
           .padding(horizontal = 25.dp),
       horizontalAlignment = Alignment.CenterHorizontally
   ) {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(top = 30.dp, bottom = 4.dp),
           horizontalArrangement = Arrangement.Center
       ) {

           if(isWon){

               Text(
                   text = "You won",
                   color = MaterialTheme.colorScheme.primary,
                   fontSize = 35.sp,
                   fontWeight = FontWeight.ExtraBold,
                   textAlign = TextAlign.Center
               )

           }else{
               Text(
                   text = "Wrong answer",
                   color = MaterialTheme.colorScheme.primary,
                   fontSize = 35.sp,
                   fontWeight = FontWeight.ExtraBold,
                   textAlign = TextAlign.Center
               )
           }
       }

       Spacer(modifier = Modifier.height(45.dp))


       Row(
           modifier = Modifier
               .fillMaxWidth(),
           horizontalArrangement = Arrangement.Center
       ) {

           if(isWon){

               Image(
                   painter = painterResource(id = R.drawable.happy_mushroom),
                   contentDescription = "happy_mushroom",
                   contentScale = ContentScale.FillWidth,
                   modifier = Modifier
                       .fillMaxWidth()
                   .padding(start = 7.dp))


           }else{
               Image(
                   painter = painterResource(id = R.drawable.sad_mushroom_ps),
                   contentDescription = "sad_mushroom",
                   contentScale = ContentScale.FillWidth,
                   modifier = Modifier
                       .fillMaxWidth()
                       .padding(start = 35.dp))
           }

       }
       Row(
           modifier = Modifier
               .fillMaxWidth(),
           horizontalArrangement = Arrangement.Center
       ){
           Text(
               text = "Your score: ${score}",
               color = MaterialTheme.colorScheme.primary,
               fontSize = 26.sp,
               fontWeight = FontWeight.Bold,
               textAlign = TextAlign.Center
           )
       }

       Spacer(modifier = Modifier.height(30.dp))

       Row(
           modifier = Modifier
               .fillMaxWidth(),
           horizontalArrangement = Arrangement.Center
       ){
           Button(
               modifier = Modifier.fillMaxWidth(),
               colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
               shape = RoundedCornerShape(9.dp),
               onClick = {
                    navController.popBackStack()
                   navController.navigate(Screen.QuizScreen.route)
               }) {
               Text(
                   text = "Back to Scoreboard",
                   fontWeight = FontWeight.Bold,
                   textAlign = TextAlign.Center,
                   color = MaterialTheme.colorScheme.primary
               )
           }
       }
   }
}