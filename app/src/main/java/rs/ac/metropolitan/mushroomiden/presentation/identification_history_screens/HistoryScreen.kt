package rs.ac.metropolitan.mushroomiden.presentation.identification_history_screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Pin
import androidx.compose.material.icons.rounded.PinDrop
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.domain.model.CompletedIdentificationEntity
import rs.ac.metropolitan.mushroomiden.presentation.identification_history_screens.components.HistoryItemCard
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen


@Composable
fun HistoryScreen(
    navController: NavController,
    viewModel: CompletedIdentificationsHistoryViewModel = hiltViewModel()
) {

    val historyIdentificationsState = viewModel.allIdentificationsResultState.value


    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, bottom = 7.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Identification History",
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }

                Spacer(modifier = Modifier.height(22.dp))
            }

            items(historyIdentificationsState.completedIdentifications) {completedIdentification->

                HistoryItemCard(
                    completedIdentification = completedIdentification,
                onItemClick = {
                    navController.navigate(Screen.IdentificationResultScreen.route + "/${completedIdentification.accessToken}")
                })
                
                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}



