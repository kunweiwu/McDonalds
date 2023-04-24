package tw.mason.mcdonalds.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import coil.request.ImageRequest

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
                    model = ImageRequest.Builder(LocalContext.current)
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