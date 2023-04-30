package tw.mason.mcdonalds.screen.home

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.mason.mcdonalds.R


@Preview
@Composable
fun SectionTask(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        HomeSectionHeader(
            text = "專屬任務"
        )
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
        ) {
            ItemTask(
                img = R.drawable.img_task2,
                text = "賺分賺優惠 好運享美味"
            )
            Spacer(modifier = Modifier.width(12.dp))
            ItemTask(
                img = R.drawable.img_task1,
                text = "快來填問卷 回饋賺起來"
            )
        }
    }
}

@Composable
fun ItemTask(
    modifier: Modifier = Modifier,
    @DrawableRes img: Int = R.drawable.img_task1,
    text: String = ""
) {
    Column(modifier = modifier.width(160.dp)) {
        Image(
            painter = painterResource(id = img),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = text, modifier = Modifier)
    }
}