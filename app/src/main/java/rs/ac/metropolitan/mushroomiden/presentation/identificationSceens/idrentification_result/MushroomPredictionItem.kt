package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.idrentification_result

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Top
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.node.ModifierNodeElement
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.R
import rs.ac.metropolitan.mushroomiden.data.remote.dto.Suggestion
import rs.ac.metropolitan.mushroomiden.presentation.theme.c1
import rs.ac.metropolitan.mushroomiden.presentation.theme.c2
import rs.ac.metropolitan.mushroomiden.presentation.theme.c3
import rs.ac.metropolitan.mushroomiden.presentation.theme.c4
import rs.ac.metropolitan.mushroomiden.presentation.theme.c5
import rs.ac.metropolitan.mushroomiden.presentation.theme.c6

@Composable
fun MushroomPredcitionItem(suggestion: Suggestion, onSelected: (Suggestion) -> Unit) {

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

                            //c1, c2, c3, c4, c5, c6
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
            MushroomPicture(image = suggestion.similar_images[0].url, name = suggestion.name) {
                openDialog = false
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