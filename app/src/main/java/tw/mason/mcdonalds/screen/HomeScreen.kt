package tw.mason.mcdonalds.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.mason.mcdonalds.R
import tw.mason.mcdonalds.ui.theme.YELLOW

@Preview
@Composable
fun HomeScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.img_home_icon),
                contentDescription = null,
                modifier = Modifier
                    .size(46.dp)
                    .shadow(0.dp)
                    .rotate(180f)
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_card_red),
                    contentDescription = null,
                    modifier = Modifier
                        .size(34.dp)
                        .align(Alignment.CenterVertically)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Box(
                    modifier = Modifier.size(38.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.outline_notifications_24),
                        contentDescription = null,
                        tint = Color(0xFFB4B4B4),
                        modifier = Modifier
                            .size(34.dp)
                            .scale(1f, 0.9f)
                            .align(Alignment.Center)
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .fillMaxSize(0.45f)
                            .clip(CircleShape)
                            .background(YELLOW)
                    ) {
                        Text(
                            text = "3",
                            fontSize = MaterialTheme.typography.labelSmall.fontSize,
                            color = Color.White,
                            modifier = Modifier.align(Alignment.Center)

                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "晚安!", fontSize = 32.sp)
        }
    }
}