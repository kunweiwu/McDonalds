package tw.mason.mcdonalds.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen() {
    Column(
        Modifier.fillMaxSize()
    ) {
        Text(text = "Home!", fontSize = 40.sp)
    }
}