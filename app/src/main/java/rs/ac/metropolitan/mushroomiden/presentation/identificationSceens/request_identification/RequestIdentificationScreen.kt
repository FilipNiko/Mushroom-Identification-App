package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification

import android.content.ContentResolver
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.IdentificationSharedViewModel
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification.components.CameraImagePickerCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification.components.GalleryImagePickerCard
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification.components.LocationScreen
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RequestIdentificationScreen(
    navController: NavController,
    viewModel: IdentificationSharedViewModel,
    contentResolver: ContentResolver = LocalContext.current.contentResolver
) {

    val state = viewModel.state.value

    val selectedImageUris by viewModel.selectedImageUris.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 25.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 4.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Request Identification",
                color = MaterialTheme.colorScheme.primary,
                fontSize = 27.sp,
                fontWeight = FontWeight.ExtraBold,
            )
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 25.dp, bottom = 3.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        ){
            CameraImagePickerCard(viewModel = viewModel)
            GalleryImagePickerCard(viewModel = viewModel)

        }


        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Center
        ) {
            LocationScreen(viewModel = viewModel)
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 7.dp),
            horizontalArrangement = Arrangement.Center

        ) {
            if (selectedImageUris.isNotEmpty()) {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                    shape = RoundedCornerShape(9.dp),
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        viewModel.getIdentificationResultAndInsertIntoDatabase(contentResolver)
                        navController.navigate(Screen.IdentificationResultScreen.route + "/0")
                    }) {
                    Text(
                        text = "Get Identification result",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(100.dp),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalItemSpacing = 16.dp
        ) {
            items(selectedImageUris) { uri ->


                Box{
                    AsyncImage(
                        model = uri,
                        contentDescription = null,
                        modifier = Modifier
                            .shadow(elevation = 20.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    Icon(Icons.Filled.Delete,
                        contentDescription = "remove",
                    tint = Color.White,
                    modifier= Modifier
                        .padding(top=5.dp, start=3.dp)
                        .clickable { viewModel.removeUri(uri)})
                }

            }

        }
    }

}








