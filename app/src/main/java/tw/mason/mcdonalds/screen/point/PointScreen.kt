package tw.mason.mcdonalds.screen.point

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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import tw.mason.mcdonalds.R
import tw.mason.mcdonalds.ui.theme.YELLOW


private val horizontalPadding = 16.dp

@Preview
@Composable
fun PointScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFBFBFB))
            .padding(top = 20.dp)
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(12.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = horizontalPadding),
            state = rememberLazyGridState(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            header {
                Column(
                    modifier = Modifier
                ) {
                    SearchBar()
                    Spacer(modifier = Modifier.height(8.dp))
                    TagSection()
                }
            }
            val list = listOf(
                PointExchangeItem(
                    "中杯可口可樂",
                    40,
                    "https://s7d1.scene7.com/is/image/mcdonalds/coke-zero_860x822_2:nutrition-calculator-tile-desktop?resmode=sharp2"
                ),
                PointExchangeItem(
                    "中杯檸檬風味紅茶",
                    40,
                    "https://s7d1.scene7.com/is/image/mcdonalds/iced-black-tea-lemon-flavor_832x822:nutrition-calculator-tile-desktop?resmode=sharp2"
                ),
                PointExchangeItem(
                    "原味麥脆炸雞(2塊)",
                    120,
                    "https://s7d1.scene7.com/is/image/mcdonalds/chicken-mccrispy-2-pieces_832x822:1-4-product-tile-desktop"
                ),
                PointExchangeItem(
                    "辣味麥脆炸雞(2塊)",
                    120,
                    "https://s7d1.scene7.com/is/image/mcdonalds/spicy-chicken-mccrispy-2-pieces_0321-3:1-4-product-tile-desktop"
                ),
            )
            items(list) {
                PointItem(
                    text = it.name,
                    pointText = it.point.toString(),
                    image = {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(it.imageUrl)
                                .build(),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(10.dp)
                                .fillMaxWidth()
                                .height(90.dp)
                        )
                    }
                )
            }
        }
    }
}

fun LazyGridScope.header(
    content: @Composable LazyGridItemScope.() -> Unit
) {
    item(span = { GridItemSpan(this.maxLineSpan) }, content = content)
}

@Composable
private fun TagSection() {
    val space = 8.dp
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space),
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.width(horizontalPadding - space))
        TabButton(
            modifier = Modifier,
            icon = R.drawable.img_sort,
            enabled = true,
            text = "排序"
        ) {
            // todo
        }
        TabButton(
            modifier = Modifier,
            enabled = false,
            text = "熱門兌換"
        ) {
            // todo
        }
        TabButton(
            modifier = Modifier,
            enabled = true,
            text = "點數兌換"
        ) {
            // todo
        }
        TabButton(
            modifier = Modifier,
            enabled = true,
            text = "加價兌換"
        ) {
            // todo
        }
        TabButton(
            modifier = Modifier,
            enabled = true,
            text = "所有兌換"
        ) {
            // todo
        }
        Spacer(modifier = Modifier.width(horizontalPadding - space))
    }
}

@Composable
private fun SearchBar() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
            .background(Color(0xFFF8F8F8), CircleShape)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.round_search_24),
            contentDescription = null,
            modifier = Modifier
                .padding(8.dp)
                .size(26.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "搜尋兌換商品名稱", color = Color(0xFF595959))
    }
}

@Composable
private fun TopSection() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = horizontalPadding)
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
                fontSize = MaterialTheme.typography.titleMedium.fontSize
            )
        }
    }
}

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