package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.IdentificationSharedViewModel
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.BasicInfoCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.CharacteristicCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.CommonNamesCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.DescriptionCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.ImagesWithOverlay
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.LookAlikeCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.TaxonomyCard

@Composable
fun SuggestionDetailsScreen(
    navController: NavController,
    viewModel: IdentificationSharedViewModel
) {

    val suggestion = viewModel.suggestionDetails.value
    var expanded by remember { mutableStateOf(false) }


    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        item {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 3.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${suggestion.name}".uppercase(),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize=30.sp,
                    fontWeight= FontWeight.ExtraBold,
                    lineHeight = 35.sp,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ImagesWithOverlay(
                    viewModel.getLeftHeatMapImageUrl(),
                    viewModel.getRightHeatMapImageUrl()
                )
            }
            Spacer(modifier = Modifier.height(25.dp))

            BasicInfoCard(suggestion = suggestion)

            Spacer(modifier = Modifier.height(22.dp))

            if(suggestion.details?.description !=null){
                DescriptionCard(description = suggestion.details.description.value)
                Spacer(modifier = Modifier.height(25.dp))
            }

            if(suggestion.details?.taxonomy !=null){
                TaxonomyCard(taxonomy = suggestion.details.taxonomy)
                Spacer(modifier = Modifier.height(25.dp))
            }

            if(suggestion.details?.common_names !=null){
                CommonNamesCard(commonNames = suggestion.details.common_names)
                Spacer(modifier = Modifier.height(25.dp))
            }

            
            CharacteristicCard(suggestion = suggestion)

            Spacer(modifier = Modifier.height(25.dp))

            LookAlikeCard(suggestion = suggestion )

            Spacer(modifier = Modifier.height(25.dp))

        }
    }
}





