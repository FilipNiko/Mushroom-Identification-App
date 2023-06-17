package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.idrentification_result.components

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rs.ac.metropolitan.mushroomiden.R
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Suggestion

@Composable
fun MushroomPredcitionItem(suggestion: Suggestion, context:Context, onSelected: (Suggestion) -> Unit) {

    val percentage = suggestion.probability * 100
    val formattedPercentage = String.format("%.2f%%", percentage)
    var openDialog by remember {
        mutableStateOf(false) // Initially dialog is closed
    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onSelected(suggestion)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.surfaceTint,
                            MaterialTheme.colorScheme.primaryContainer
                        )
                    )
                )
                .height(170.dp)
                .padding(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .padding(start = 8.dp, top = 10.dp)
                    .width(250.dp)
                    .align(Top)
            ) {
                Text(
                    text = "${suggestion.name}".uppercase(),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Probability: ${formattedPercentage}",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal
                )
            }


            Column(modifier = Modifier.clickable { openDialog = true })
            {
                Image(painter = painterResource(id = R.drawable.mushroom),
                    contentDescription = "icon")
                Text(
                    text = "Click for picture",
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 9.sp,
                    modifier = Modifier.padding(start=9.dp),
                    fontWeight = FontWeight.Bold
                )
            }

            
        }

        if (openDialog) {
            if(suggestion.details?.images!=null){
                MushroomPicture(images = suggestion.details!!.images, name = suggestion.name) {
                    openDialog = false
                }
            }else{
                Toast.makeText(context,"No images available!", Toast.LENGTH_LONG)
            }

        }

    }
}





/*
* AsyncImage(
                model = suggestion.similar_images[0].url,
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
* */