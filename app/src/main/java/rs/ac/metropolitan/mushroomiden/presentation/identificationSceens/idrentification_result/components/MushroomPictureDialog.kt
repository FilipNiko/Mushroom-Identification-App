package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.idrentification_result.components


import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Image

@Composable
fun MushroomPicture(
    images: List<Image>,
    name:String,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        shape = RoundedCornerShape(20.dp),
        onDismissRequest = { onDismiss() },
        containerColor = MaterialTheme.colorScheme.background,
        text = {
            ImageSlide(name = name, images = images)
        },
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    onDismiss()
                }
                ) {
                    Text(text = "Cancel")
                }
            }
        }
    )

}



@Composable
fun ImageSlide(name:String, images: List<Image>) {
    var currentIndex by remember {
        mutableStateOf(0)
    }
    val imageListSize = images.size

    var mushroomName = name
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        AsyncImage(
            model = images[currentIndex].value,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(CenterHorizontally)
                .padding(top = 30.dp, start = 30.dp, end = 30.dp, bottom = 30.dp)
                .weight(3f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp)
                .weight(0.8f)
        ) {
            Text(
                text = mushroomName,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                lineHeight = 40.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .weight(0.5f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = {
                    if(currentIndex > 0){
                        currentIndex--
                    }
                    else currentIndex = imageListSize-1
                } ,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 20.dp, end = 10.dp),
            ) {
                Text(text = "Previous")
            }

            Button(
                onClick = {
                    if(currentIndex < imageListSize-1){
                        currentIndex++
                    }
                    else currentIndex = 0
                } ,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 10.dp, end = 20.dp),
            )  {
                Text(text = "Next")
            }
        }
    }
}