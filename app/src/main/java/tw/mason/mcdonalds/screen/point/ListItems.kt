package tw.mason.mcdonalds.screen.point

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.mason.mcdonalds.R
import tw.mason.mcdonalds.ui.theme.YELLOW


data class PointExchangeItem(
    val name: String,
    val point: Int,
    val imageUrl: String,
)

@Composable
fun RowScope.PointItem(
    image: @Composable ColumnScope.() -> Unit = {},
    text: String = "中杯可口可樂",
    pointText: String = "40"
) {
    Column(
        modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        image()
        Text(
            text = text,
            minLines = 2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.img_p_with_round),
                contentDescription = null,
                tint = YELLOW,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = pointText,
                fontWeight = FontWeight.ExtraBold,
                fontSize = MaterialTheme.typography.labelLarge.fontSize
            )
        }
        // todo 加價換
        Spacer(modifier = Modifier.height(22.dp))
        ExchangeButton()
    }
}

@Preview
@Composable
private fun ExchangeButton() {
    OutlinedButton(
        onClick = { /*TODO*/ },
        border = BorderStroke(1.dp, YELLOW),
        contentPadding = PaddingValues(horizontal = 18.dp, vertical = 10.dp),
        modifier = Modifier
            .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp)
    ) {
        Text(
            text = "兌換",
            color = YELLOW,
            fontSize = MaterialTheme.typography.labelLarge.fontSize
        )
    }
}