package tw.mason.mcdonalds.screen.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.mason.mcdonalds.R
import tw.mason.mcdonalds.ui.theme.DarkRed
import tw.mason.mcdonalds.ui.theme.YELLOW

data class MainMenuObj(
    @DrawableRes val iconRes: Int = R.drawable.round_monetization_on_24,
    val tint: Color = DarkRed,
    val text: String = "儲值金",
    val value: Int = 5269,
    val onClick: () -> Unit = {}
)

@Preview
@Composable
fun MainMenu(
    modifier: Modifier = Modifier,
) {
    val items = listOf(
        MainMenuObj(),
        MainMenuObj(iconRes = R.drawable.round_local_parking_24, text = "點數", value = 99999),
        MainMenuObj(
            iconRes = R.drawable.baseline_videogame_asset_24,
            tint = YELLOW,
            text = "積分",
            value = 20
        ),
        MainMenuObj(
            iconRes = R.drawable.round_shopping_bag_24,
            text = "商品券",
            value = 0
        ),
        MainMenuObj(
            iconRes = R.drawable.ticket,
            tint = YELLOW,
            text = "優惠券",
            value = 78
        ),
    )
    Row(
        modifier = modifier,
    ) {
        items.forEach { item ->
            MainMenuItem(
                obj = item
            )
        }
    }
}

@Preview
@Composable
fun RowScope.MainMenuItem(
    modifier: Modifier = Modifier,
    obj: MainMenuObj = MainMenuObj()
) {
    Column(
        modifier = modifier
            .weight(1f)
            .clickable { obj.onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = obj.iconRes),
            contentDescription = null,
            tint = obj.tint,
            modifier = Modifier.size(22.dp)
        )
        Text(text = obj.text, fontSize = MaterialTheme.typography.labelSmall.fontSize)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = obj.value.toString(),
            fontWeight = FontWeight.ExtraBold
        )
    }
}