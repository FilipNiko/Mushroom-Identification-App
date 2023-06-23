package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.suggestion_details_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.R

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