package tw.mason.mcdonalds.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
                .scrollable(
                    state = rememberScrollState(),
                    orientation = Orientation.Vertical
                )
        ) {
            Text(
                text = "晚安!",
                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            McCarousel(modifier = Modifier.padding(horizontal = 16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            ScheduleActivity(modifier = Modifier.fillMaxWidth())
        }
    }
}


@Composable
fun McCarousel(
    modifier: Modifier = Modifier
) {
    val images = listOf(
        "https://www.mcdonalds.com/content/dam/sites/tw/carousel/2023/Carousel_0419Signature_2336x1040.png",
        "https://www.mcdonalds.com/content/dam/sites/tw/carousel/2023/Colombia0411%E5%A4%A7%E9%A6%96%E9%A0%81%E8%BC%AA%E6%92%AD_2336x1040.png",
    )

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp)
    ) {
        @OptIn(ExperimentalFoundationApi::class)
        AutoSlidingCarousel(itemsCount = images.size) { index ->
            AsyncImage(
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(images[index])
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(140.dp)
            )
        }
    }
}

@Composable
fun ScheduleActivity(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HomeTitle(text = "強檔活動")
            ArrowForwardBtn()
        }
        Spacer(modifier = Modifier.height(8.dp))
        val activities = listOf(
            "https:/www.mcdonalds.com/content/dam/sites/tw/hero/2023/0407-fof2336x1040.jpg",
            "https://www.mcdonalds.com/content/dam/sites/tw/hero/2023/Colombia0411Hero_2336x1040.png",
            "https://www.mcdonalds.com/content/dam/sites/tw/hero/desktop/2022/2023%E5%BE%97%E4%BE%86%E9%80%9F%E8%B2%B4%E8%B3%93%E5%8D%A1HeroBanner2336x1040.png",
        )
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .zIndex(1f)
        ) {
            itemsIndexed(activities) { index, item ->
                if (index == 0)
                    Spacer(modifier = Modifier.width(16.dp))
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(item)
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(100.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                if (index == activities.lastIndex)
                    Spacer(modifier = Modifier.width(16.dp))
                else
                    Spacer(modifier = Modifier.width(12.dp))
            }
        }
    }
}

@Composable
fun HomeTitle(
    text: String
) {
    Text(
        text = text,
        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
        fontWeight = FontWeight.Bold,
        letterSpacing = 4.sp
    )
}

@Composable
fun ArrowForwardBtn() {
    IconButton(
        onClick = { /*TODO*/ },
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