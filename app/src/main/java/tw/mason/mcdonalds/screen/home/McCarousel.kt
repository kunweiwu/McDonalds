package tw.mason.mcdonalds.screen.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import tw.mason.mcdonalds.screen.AutoSlidingCarousel

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
        (AutoSlidingCarousel(
            itemsCount = images.size,
            pagerState = rememberPagerState { images.size }
        ) { index ->
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(images[index])
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(160.dp)
            )
        })
    }
}