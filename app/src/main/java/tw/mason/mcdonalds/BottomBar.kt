package tw.mason.mcdonalds

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import tw.mason.mcdonalds.ui.theme.DarkRed
import tw.mason.mcdonalds.ui.theme.Gray

@Preview(widthDp = 350)
@Composable
fun BottomBar(
    navHelper: NavigationHelper? = null
) {
    Row(
        modifier = Modifier
            .background(Color.Transparent),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.Bottom
    ) {
        val tabModifier = Modifier
            .weight(1f)
            .height(44.dp)
        MainTab(
            modifier = tabModifier,
            text = "首頁",
            iconPainter = painterResource(id = R.drawable.round_home_24),
            isSelected = navHelper?.isSelected(BottomBarScreen.Home) ?: false
        ) {
            navHelper?.toScreen(BottomBarScreen.Home)
        }
        MainTab(
            modifier = tabModifier,
            text = "專屬任務",
            iconPainter = painterResource(id = R.drawable.round_percent_24),
            isSelected = navHelper?.isSelected(BottomBarScreen.Task) ?: false
        ) {
            navHelper?.toScreen(BottomBarScreen.Task)
        }
        PayTab(
            modifier = Modifier.clickable {
                // TODO
            },
            text = "付款/儲值",
        )
        MainTab(
            modifier = tabModifier,
            text = "點數商城",
            iconPainter = painterResource(id = R.drawable.round_local_parking_24),
            isSelected = navHelper?.isSelected(BottomBarScreen.Point) ?: false
        ) {
            navHelper?.toScreen(BottomBarScreen.Point)
        }
        MainTab(
            modifier = tabModifier,
            text = "我的帳號",
            iconPainter = painterResource(id = R.drawable.round_person_24),
            isSelected = navHelper?.isSelected(BottomBarScreen.Account) ?: false
        ) {
            navHelper?.toScreen(BottomBarScreen.Account)
        }
    }
}

@Composable
fun RowScope.PayTab(
    modifier: Modifier,
    text: String,
) {
    Box(
        modifier = modifier
            .weight(1f)
            .height(64.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.6f)
                .aspectRatio(1f)
                .align(Alignment.TopCenter)
                .clip(CircleShape)
                .background(DarkRed)
                .zIndex(1f)
        ) {
            Icon(
                painter = painterResource(
                    id = R.drawable.round_attach_money_24
                ),
                contentDescription = text,
                tint = Color.White,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .height(44.dp)
                .background(Color.White)
                .align(Alignment.BottomCenter),
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                textAlign = TextAlign.Center,
                color = Color.LightGray,
                fontSize = MaterialTheme.typography.labelMedium.fontSize
            )
        }
    }
}

@Composable
fun MainTab(
    modifier: Modifier,
    text: String,
    iconPainter: Painter,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = modifier
            .background(Color.White)
            .clickable { onClick.invoke() },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        val color = if (isSelected) DarkRed else Gray
        Icon(
            painter = iconPainter,
            tint = color,
            contentDescription = text,
        )
        Text(
            text = text,
            color = color,
            fontSize = MaterialTheme.typography.labelMedium.fontSize
        )
    }
}
