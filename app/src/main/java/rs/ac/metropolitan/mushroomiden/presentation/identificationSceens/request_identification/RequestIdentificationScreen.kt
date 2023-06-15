package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification

import android.content.ContentResolver
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.IdentificationSharedViewModel

@Composable
fun RequestIdentificationScreen(
    navController: NavController,
    viewModel: IdentificationSharedViewModel,
    contentResolver: ContentResolver = LocalContext.current.contentResolver){

    val state = viewModel.state.value

    val selectedImageUris by viewModel.selectedImageUris.collectAsState()

    val multiplePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickMultipleVisualMedia(),
        onResult = { uris ->
            viewModel.setSelectedImageUris(uris)
        }
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(onClick = {
                    multiplePhotoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                }) {
                    Text(text = "Pick multiple photo")
                }
                Button(onClick = {
                    viewModel.convertUrisToBase64(contentResolver)
                    navController.navigate(Screen.IdentificationResultScreen.route)
                }) {
                    Text(text = "Convert to Base64")
                }
            }
        }


        items(selectedImageUris) { uri ->
            AsyncImage(
                model = uri,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
        }
    }




}