package tw.mason.mcdonalds.screen.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.mason.mcdonalds.R
import tw.mason.mcdonalds.ui.theme.Gray
import tw.mason.mcdonalds.ui.theme.YELLOW

data class MiniMenuObj(
    @DrawableRes val iconRes: Int,
    val text: String,
    val onClick: () -> Unit = {}
)

@Preview
@Composable
fun MiniMenu(
    modifier: Modifier = Modifier,
) {
    val items = listOf(
        MiniMenuObj(R.drawable.round_card_giftcard_24, "最新任務"),
        MiniMenuObj(R.drawable.outline_fastfood_24, "隨買店取"),
        MiniMenuObj(R.drawable.baseline_delivery_dining_24, "歡樂送"),
        MiniMenuObj(R.drawable.round_checklist_24, "滿意度調查"),
        MiniMenuObj(R.drawable.round_add_circle_outline_24, "立即儲值"),
        MiniMenuObj(R.drawable.round_list_alt_24, "交易紀錄"),
    )
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState()),
    ) {
        Spacer(modifier = Modifier.width(16.dp))
            items.forEachIndexed { index, item ->
            MiniMenuItem(
                obj = item
            )
            if (index != items.lastIndex)
                Spacer(modifier = Modifier.width(12.dp))
        }
        Spacer(modifier = Modifier.width(16.dp))
    }
}

@Preview
@Composable
fun MiniMenuItem(
    modifier: Modifier = Modifier,
    obj: MiniMenuObj = MiniMenuObj(R.drawable.round_card_giftcard_24, "最新任務")
) {
    Column(
        modifier = modifier
            .clickable { obj.onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedIconButton(
            onClick = {},
            border = BorderStroke(1.dp, brush = Brush.horizontalGradient(listOf(Gray, Gray)))
        ) {
            Icon(
                painter = painterResource(id = obj.iconRes),
                contentDescription = null,
                tint = YELLOW
            )
        }
        Text(text = obj.text)
    }
}