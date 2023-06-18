package rs.ac.metropolitan.mushroomiden.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import rs.ac.metropolitan.mushroomiden.presentation.navigation.BottomNav
import rs.ac.metropolitan.mushroomiden.presentation.theme.AppTheme


@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {

                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),color = MaterialTheme.colorScheme.background) {
                    BottomNav()
                }
            }
        }
    }
}




@Composable
fun Greeting2(name: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
@Composable
fun Greeting3(name: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

