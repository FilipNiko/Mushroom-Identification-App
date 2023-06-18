package rs.ac.metropolitan.mushroomiden.presentation.identification_history_screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.rounded.PinDrop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity

@Composable
fun HistoryItemCard(completedIdentification: CompletedIdentificationEntity, onItemClick: (CompletedIdentificationEntity) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(completedIdentification) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            AsyncImage(
                model = completedIdentification.imagesUrl,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .width(250.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                ){

                    Icon(
                        imageVector = Icons.Default.CalendarMonth,
                        contentDescription = "calendar icon",
                        tint = MaterialTheme.colorScheme.inversePrimary,
                    )

                    Text(
                        text = "${completedIdentification.date}",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 17.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                }
                Spacer(modifier = Modifier.height(10.dp))

                Row(modifier = Modifier
                    .fillMaxWidth()
                ){

                    Icon(
                        imageVector = Icons.Rounded.PinDrop,
                        contentDescription = "location icon",
                        tint = MaterialTheme.colorScheme.inversePrimary
                    )

                    if(completedIdentification.latitude != null && completedIdentification.latitude != 0.0){
                        Text(
                            text = "Near: ${completedIdentification.city} - ${completedIdentification.country}",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 13.sp,
                            lineHeight = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }else{
                        Text(
                            text = "No location was provided at the time of the request",
                            color = MaterialTheme.colorScheme.secondary,
                            fontSize = 13.sp,
                            lineHeight = 14.sp,
                            modifier = Modifier.align(Alignment.CenterVertically)
                        )
                    }

                }
            }
        }
    }
}
