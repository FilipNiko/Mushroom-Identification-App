package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rs.ac.metropolitan.mushroomiden.data.remote.dto.LookAlike
import rs.ac.metropolitan.mushroomiden.data.remote.dto.Suggestion

@Composable
fun LookAlikeCard(suggestion: Suggestion) {


    Text(
        text = "Look-Alike",
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

        if (suggestion.details?.look_alike != null) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                suggestion.details.look_alike.forEach { lookAlike ->

                    LookAlikeItem(name = lookAlike.name)

                    Spacer(modifier = Modifier.height(1.dp))
                    Divider(color = Color.Gray, thickness = 0.5.dp)
                    Spacer(modifier = Modifier.height(1.dp))
                }
            }
        } else {
            LookAlikeItem(name = "No Look-Alikes")
        }

    }


}




@Composable
fun LookAlikeItem(name: String) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Text(
            text = "${name}",
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Start
        )
    }
}