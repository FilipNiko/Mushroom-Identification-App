package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen

import android.content.ContentResolver
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.R
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.IdentificationSharedViewModel
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.BasicInfoCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.CharacteristicCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.CommonNamesCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.DescriptionCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.ExpandableText
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.ImagesWithOverlay
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.LookAlikeCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.LookAlikeItem
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components.TaxonomyCard
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen

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





