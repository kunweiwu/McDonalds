package tw.mason.mcdonalds.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ArrowForwardBtn(
    onClick: () -> Unit
) {
    IconButton(
        onClick = { onClick.invoke() },
        modifier = Modifier
            .background(Color(0xFFEFEFEF), CircleShape)
            .size(30.dp)
    ) {
        Icon(
            imageVector = Icons.Default.ArrowForward,
            contentDescription = null,
            tint = Color(0xFF666666),
            modifier = Modifier.size(16.dp)
        )
    }
}