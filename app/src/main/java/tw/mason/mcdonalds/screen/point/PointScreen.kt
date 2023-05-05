package tw.mason.mcdonalds.screen.point

import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
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

private val bgColor = Color(0xFFFBFBFB)

@Preview
@Composable
fun PointScreen(
    uiState: PointUiState = PointUiState.Success()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bgColor)
            .padding(top = 20.dp)
    ) {
        TopSection()
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                SearchBar()
            }
            @OptIn(ExperimentalFoundationApi::class)
            stickyHeader {
                TagSection()
            }
            when(uiState) {
                is PointUiState.Loading -> {
                    item {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .fillMaxWidth(0.2f)
                        )
                    }
                }
                is PointUiState.Success -> {
                    itemsIndexed(uiState.list) { index, _ ->
                        print(index)
                        Row(
                            modifier = Modifier.padding(horizontal = horizontalPadding)
                        ) {
                            val itemLeft = uiState.list.getOrNull(index * 2)
                            if (itemLeft != null) {
                                PointItem(
                                    text = itemLeft.name,
                                    pointText = itemLeft.point.toString(),
                                    image = {
                                        AsyncImage(
                                            model = ImageRequest.Builder(LocalContext.current)
                                                .data(itemLeft.imageUrl)
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
                                Spacer(modifier = Modifier.width(10.dp))
                                val itemRight = uiState.list.getOrNull(index * 2 + 1)
                                if (itemRight != null) {
                                    PointItem(
                                        text = itemRight.name,
                                        pointText = itemRight.point.toString(),
                                        image = {
                                            AsyncImage(
                                                model = ImageRequest.Builder(LocalContext.current)
                                                    .data(itemRight.imageUrl)
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
                                } else {
                                    Spacer(modifier = Modifier.weight(1f))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
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
            .background(bgColor)
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
            .background(Color(0xFFF4F4F4), CircleShape)
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