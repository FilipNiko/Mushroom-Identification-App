package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.identification_result

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.IdentificationSharedViewModel
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.identification_result.components.MushroomPredcitionItem
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen

@Composable
fun IdentificationResultScreen(
    navController: NavController,
    viewModel: IdentificationSharedViewModel,
    accessToken:String
) {

    LaunchedEffect(Unit) {
        viewModel.getIdentificationsByAccessToken(accessToken)
    }

    val state = viewModel.state.value

    Box(modifier = Modifier.fillMaxSize()) {

        state.identificationResult?.let { results ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
            ) {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top=10.dp, bottom = 30.dp),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        Text(
                            text = "Predictions",
                            fontSize=30.sp,
                            fontWeight= FontWeight.ExtraBold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
                items(results.result.classification.suggestions) { suggestion ->
                    MushroomPredcitionItem(suggestion = suggestion, LocalContext.current){
                        viewModel.setSelectedSuggestion(it)
                        navController.navigate(Screen.SuggestionDetailsScreen.route)
                    }
                }
            }

        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

    }
}
