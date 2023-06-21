package rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification.components

import android.Manifest
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.IdentificationSharedViewModel

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun LocationScreen(
    viewModel: IdentificationSharedViewModel
) {
    val locationPermissions = rememberMultiplePermissionsState(
        permissions = listOf(
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    var checked by remember {
        mutableStateOf(false)
    }

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


                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { checked_ ->
                                checked = checked_
                                if (checked) {
                                    viewModel.getCurrentLocationWithDetails()
                                }
                                viewModel.setUseLocation(checked_)
                            }
                        )

                        Text(
                            modifier = Modifier.padding(start = 2.dp),
                            text = "Use my location"
                        )
                    }
                    if (currentLocation.locationResultInfo?.city != null && currentLocation.locationResultInfo?.countryName != null && checked) {
                        Text(
                            text = "Near: ${currentLocation.locationResultInfo!!.city}, ${currentLocation.locationResultInfo!!.countryName}",
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.primary
                        )
                    } else if (currentLocation.locationResultInfo == null && checked) {
                        Text(text = "Error: Please turn of you location")
                    }

                } else {
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                        shape = RoundedCornerShape(9.dp),
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { locationPermissions.launchMultiplePermissionRequest() }
                    ) {
                        Text(
                            text = "Accept location permission",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.primary)
                    }

                }

            }
        }
    }
}