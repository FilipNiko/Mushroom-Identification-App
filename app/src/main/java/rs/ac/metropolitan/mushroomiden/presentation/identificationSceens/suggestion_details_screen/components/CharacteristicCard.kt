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
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import rs.ac.metropolitan.mushroomiden.data.remote.mushroom_dentification.dto.Suggestion

@Composable
fun CharacteristicCard(suggestion: Suggestion) {


    Text(
        text = "Characteristic",
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

            if (suggestion.details?.edibility != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Edibility",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "${suggestion.details!!.edibility}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.End
                    )
                }
                Spacer(modifier = Modifier.height(1.dp))
                Divider(color = Color.Gray, thickness = 0.5.dp)
                Spacer(modifier = Modifier.height(1.dp))
            }


            if (suggestion.details?.psychoactive != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Psychoactive",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Start
                    )
                    Text(
                        text = "${suggestion.details!!.psychoactive}",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.End
                    )
                }
            }

            suggestion.details?.characteristic?.let {


                Spacer(modifier = Modifier.height(1.dp))
                Divider(color = Color.Gray, thickness = 0.5.dp)
                Spacer(modifier = Modifier.height(1.dp))


                if (suggestion.details.characteristic.hymeniumType != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Hymenium type",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "${suggestion.details!!.characteristic.hymeniumType}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(1.dp))
                    Divider(color = Color.Gray, thickness = 0.5.dp)
                    Spacer(modifier = Modifier.height(1.dp))

                }

                if (suggestion.details.characteristic.hymeniumAttachment != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Hymenium attachment",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .weight(7f)
                                .align(CenterVertically)
                        )
                        Text(
                            text = "${suggestion.details!!.characteristic.hymeniumAttachment}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .weight(3f)
                                .align(CenterVertically)
                        )
                    }
                    Spacer(modifier = Modifier.height(1.dp))
                    Divider(color = Color.Gray, thickness = 0.5.dp)
                    Spacer(modifier = Modifier.height(1.dp))
                }

                if (suggestion.details.characteristic.stipeCharacter != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Stipe character",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "${suggestion.details!!.characteristic.stipeCharacter}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.End
                        )
                    }


                    Spacer(modifier = Modifier.height(1.dp))
                    Divider(color = Color.Gray, thickness = 0.5.dp)
                    Spacer(modifier = Modifier.height(1.dp))
                }

                if (suggestion.details.characteristic.sporePrintColor != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Spore Color",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Start
                        )
                        Text(
                            text = "${suggestion.details!!.characteristic.sporePrintColor}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(1.dp))
                    Divider(color = Color.Gray, thickness = 0.5.dp)
                    Spacer(modifier = Modifier.height(1.dp))
                }


                if (suggestion.details.characteristic.mushroomCapShape != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Mushroom cap shape",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .weight(7f)
                                .align(CenterVertically)
                        )
                        Text(
                            text = "${suggestion.details!!.characteristic.mushroomCapShape}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .weight(3f)
                                .align(CenterVertically)
                        )
                    }


                    Spacer(modifier = Modifier.height(1.dp))
                    Divider(color = Color.Gray, thickness = 0.5.dp)
                    Spacer(modifier = Modifier.height(1.dp))

                }


                if (suggestion.details.characteristic.mushroomEcologicalType != null) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Mushroom ecological type",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.Start,
                            modifier = Modifier
                                .weight(7f)
                                .align(CenterVertically)
                        )
                        Text(
                            text = "${suggestion.details!!.characteristic.mushroomEcologicalType}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            style = MaterialTheme.typography.labelMedium,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .weight(3f)
                                .align(CenterVertically)
                        )
                    }

                }
            }
        }

    }


}