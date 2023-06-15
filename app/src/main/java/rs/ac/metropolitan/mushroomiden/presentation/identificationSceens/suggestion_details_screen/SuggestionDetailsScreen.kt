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
                    .padding(top = 5.dp, bottom = 7.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "${suggestion.name}",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.titleLarge,
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

          /*  Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Phylum: ${suggestion.details?.taxonomy?.phylum}",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic,
                )
                Text(
                    text = "Family: ${suggestion.details?.taxonomy?.family}",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.End,
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Order: ${suggestion.details?.taxonomy?.order}",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic,
                )
                Text(
                    text = "Genus: ${suggestion.details?.taxonomy?.genus}",
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = MaterialTheme.typography.bodySmall,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.End,
                )
            }*/

            Spacer(modifier = Modifier.height(7.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ImagesWithOverlay(
                    viewModel.getLeftHeatMapImageUrl(),
                    viewModel.getRightHeatMapImageUrl()
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            Text(text = "Description",
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
            ){
                /*Text(text = "${suggestion.details?.description?.value}",
                    modifier = Modifier
                        .padding(15.dp),
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Start
                )*/
                ExpandableText(text = suggestion.details!!.description!!.value,
                    modifier  = Modifier
                        .padding(15.dp))
            }
            Spacer(modifier = Modifier.height(5.dp))

        }
    }
}


@Composable
fun ImagesWithOverlay(leftOverlayImage: String, rightOverlayImage: String) {
    Column(modifier = Modifier.clip(RoundedCornerShape(15.dp))) {
        Row {
            Box(Modifier.weight(1f)) {
                Image(
                    painter = painterResource(id = R.drawable.ms001x),
                    contentDescription = "001x" //Left blank map image
                )
                AsyncImage(
                    model = leftOverlayImage,// Left overlay (left heat map image)
                    contentDescription = "001xOverlay",
                    modifier = Modifier.matchParentSize()
                )
            }
            Box(Modifier.weight(1f)) {
                Image(
                    painter = painterResource(R.drawable.ms011x), //Right blank map image
                    contentDescription = "Druga slika"
                )
                AsyncImage(
                    model = rightOverlayImage,// Right overlay (right heat map image)
                    contentDescription = "001xOverlay",
                    modifier = Modifier.matchParentSize()
                )
            }
        }
    }
}


const val DEFAULT_MINIMUM_TEXT_LINE = 6

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    fontStyle: FontStyle? = null,
    text: String,
    collapsedMaxLine: Int = DEFAULT_MINIMUM_TEXT_LINE,
    showMoreText: String = "... Show More",
    showMoreStyle: SpanStyle = SpanStyle(fontWeight = FontWeight.Bold),
    showLessText: String = " Show Less",
    showLessStyle: SpanStyle = showMoreStyle,
    textAlign: TextAlign? = null
) {
    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableStateOf(0) }
    Box(modifier = Modifier
        .clickable(clickable) {
            isExpanded = !isExpanded
        }
        .then(modifier)
    ) {
        Text(
            modifier = textModifier
                .fillMaxWidth()
                .animateContentSize(),
            //color = MaterialTheme.colorScheme.primary,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        append(text)
                        withStyle(style = showLessStyle) { append(showLessText) }
                    } else {
                        val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLast(showMoreText.length)
                            .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                        append(adjustText)
                        withStyle(style = showMoreStyle) { append(showMoreText) }
                    }
                } else {
                    append(text)
                }
            },
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            fontStyle = fontStyle,
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = textLayoutResult.getLineEnd(collapsedMaxLine - 1)
                }
            },
            style = style,
            textAlign = textAlign
        )
    }

}