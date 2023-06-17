package rs.ac.metropolitan.mushroomiden.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.idrentification_result.IdentificationResultScreen
import rs.ac.metropolitan.mushroomiden.presentation.identificationSceens.request_identification.RequestIdentificationScreen
import rs.ac.metropolitan.mushroomiden.presentation.navigation.NavSetup
import rs.ac.metropolitan.mushroomiden.presentation.navigation.Screen
import rs.ac.metropolitan.mushroomiden.presentation.theme.AppTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavSetup(navController = navController)
                }
            }
        }
    }
}

