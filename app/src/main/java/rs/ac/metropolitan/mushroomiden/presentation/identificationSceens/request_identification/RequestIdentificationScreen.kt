package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification

import android.annotation.SuppressLint
import android.content.ContentResolver
import android.os.Looper
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
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
                if(selectedImageUris.isNotEmpty()) {
                    Button(onClick = {
                        viewModel.getIdentificationResultAndInsertIntoDatabase(contentResolver)
                        navController.navigate(Screen.IdentificationResultScreen.route)
                    }) {
                        Text(text = "Get Identification result")
                    }
                }
            }
            LocationScreen(viewModel = viewModel)
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

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationScreen(
    viewModel: IdentificationSharedViewModel
) {
    val locationPermissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    val currentLocation by viewModel.locationInfoState

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        AnimatedContent(
            targetState = locationPermissions.allPermissionsGranted
        ) { areGranted ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                if (areGranted) {

                    var checked by remember {
                        mutableStateOf(false)
                    }

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked_ ->
                                checked = checked_
                                if(checked){
                                    viewModel.getCurrentLocationWithDetails()
                                }
                            }
                        )

                        Text(
                            modifier = Modifier.padding(start = 2.dp),
                            text = "Use my location with this identification request"
                        )
                    }
                    if(currentLocation.locationResultInfo?.city!=null && currentLocation.locationResultInfo?.countryName!=null){
                        Text(text = "Current location near: ${currentLocation.locationResultInfo!!.city}, ${currentLocation.locationResultInfo!!.countryName}")
                    }else if(currentLocation.locationResultInfo==null && checked){
                        Text(text = "Error: Please turn of you location")
                    }

                } else {
                    Button(
                        onClick = { locationPermissions.launchMultiplePermissionRequest() }
                    ) {
                        Text(text = "Accept location permission")
                    }

                }

            }
        }
    }
}






