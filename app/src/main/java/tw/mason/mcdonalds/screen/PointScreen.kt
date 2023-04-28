package tw.mason.mcdonalds.screen

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.unit.sp
import tw.mason.mcdonalds.R
import tw.mason.mcdonalds.ui.theme.YELLOW


@Preview()
@Composable
fun PointScreen() {
    val padding = 20.dp
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(top = padding)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = padding)
        ) {
            Text(
                text = "點數商城",
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = FontWeight.Bold,
                letterSpacing = 4.sp
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.img_p_with_round),
                    contentDescription = null,
                    tint = YELLOW,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "69",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = padding)
                .background(Color(0xFFF8F8F8), CircleShape)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.round_search_24),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = "搜尋兌換商品名稱", color = Color(0xFF595959))
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.width(padding))
            TabButton(
                modifier = Modifier,
                icon = R.drawable.img_sort,
                enabled = true,
                text = "排序"
            )
            Spacer(modifier = Modifier.width(8.dp))
            TabButton(
                modifier = Modifier,
                enabled = false,
                text = "熱門兌換"
            )
            Spacer(modifier = Modifier.width(8.dp))
            TabButton(
                modifier = Modifier,
                enabled = true,
                text = "點數兌換"
            )
            Spacer(modifier = Modifier.width(8.dp))
            TabButton(
                modifier = Modifier,
                enabled = true,
                text = "加價兌換"
            )
            Spacer(modifier = Modifier.width(8.dp))
            TabButton(
                modifier = Modifier,
                enabled = true,
                text = "所有兌換"
            )
            Spacer(modifier = Modifier.width(padding))
        }
    }
}

@Preview
@Composable
fun TabButton(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int? = null,
    enabled: Boolean = true,
    text: String = "TEST",
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier
            .wrapContentHeight()
            .defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
        enabled = enabled,
        onClick = { onClick.invoke() },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFEFEFEF),
            contentColor = Color.Black,
            disabledContainerColor = YELLOW,
            disabledContentColor = Color.Black
        ),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp),
    ) {
        if (icon != null) {
            Icon(
                painter = painterResource(id = icon), contentDescription = null,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
        }
        Text(text = text)
    }
}