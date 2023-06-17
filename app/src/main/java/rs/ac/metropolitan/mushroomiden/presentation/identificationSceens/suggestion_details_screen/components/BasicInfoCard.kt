package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Suggestion
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.idrentification_result.components.MushroomPicture


@Composable
fun BasicInfoCard(suggestion: Suggestion) {

    var openImagesDialog by remember {
        mutableStateOf(false) // Initially dialog is closed
    }

    val context = LocalContext.current
    val wikiUrl = suggestion.details?.url?:"no link available"
    val intentVisitWiki = remember { Intent(Intent.ACTION_VIEW, Uri.parse(wikiUrl)) }

    Text(
        text = "Basic info",
        color = MaterialTheme.colorScheme.tertiary,
        fontSize = 13.sp,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.labelMedium,
        textAlign = TextAlign.Start
    )
    Spacer(modifier = Modifier.height(5.dp))
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            if (suggestion.details?.url != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { context.startActivity(intentVisitWiki) }
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Wikipedia Link",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(textDecoration = TextDecoration.Underline),
                        textAlign = TextAlign.Start
                    )
                }
                Spacer(modifier = Modifier.height(1.dp))
                Divider(color = Color.Gray, thickness = 0.5.dp)
                Spacer(modifier = Modifier.height(1.dp))
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { openImagesDialog=true }
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Pictures",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    style = TextStyle(textDecoration = TextDecoration.Underline),
                    textAlign = TextAlign.Start
                )
            }

            if (openImagesDialog) {
                if(suggestion.details?.images!=null){
                    MushroomPicture(images = suggestion.details!!.images, name = suggestion.name) {
                        openImagesDialog = false
                    }
                }else{
                    Toast.makeText(LocalContext.current,"No images available!", Toast.LENGTH_LONG)
                }

            }
        }
    }
}

