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
import rs.ac.metropolitan.mushroomiden.data.remote.dto.Taxonomy

@Composable

fun TaxonomyCard(taxonomy: Taxonomy) {


    Text(
        text = "Taxonomy",
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Genus",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${taxonomy.genus}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End
                )
            }


            Spacer(modifier = Modifier.height(1.dp))
            Divider(color = Color.Gray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(1.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Order",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${taxonomy.order}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End
                )
            }


            Spacer(modifier = Modifier.height(1.dp))
            Divider(color = Color.Gray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(1.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Family",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${taxonomy.family}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End
                )
            }



            Spacer(modifier = Modifier.height(1.dp))
            Divider(color = Color.Gray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(1.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Phylum",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${taxonomy.phylum}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End
                )
            }


            Spacer(modifier = Modifier.height(1.dp))
            Divider(color = Color.Gray, thickness = 0.5.dp)
            Spacer(modifier = Modifier.height(1.dp))


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Kingdom",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start
                )
                Text(
                    text = "${taxonomy.kingdom}",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.End
                )
            }


        }
    }
}

