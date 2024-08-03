package app.map.harrypotter.presentation.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.map.harrypotter.R
import app.map.harrypotter.presentation.introscreen.homePages
import app.map.harrypotter.presentation.introscreen.pages
import app.map.harrypotter.ui.theme.HarryPotterTheme
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(){
    val CustomFontFamily = FontFamily(
        Font(R.font.harryp)
    )

    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Harry Potter",
            color = Color.White,
            style = TextStyle(fontSize= 50.sp),
            fontFamily = CustomFontFamily
        )
        val pagerState = rememberPagerState(initialPage = 0) { homePages.size }
        val matrix = remember {
            ColorMatrix()
        }

        Scaffold(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 0.dp)) {

            HorizontalPager(state = pagerState) {index ->

                val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
                val imageSize by animateFloatAsState(
                    targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
                    animationSpec = tween(durationMillis = 300)
                )

                LaunchedEffect(key1 = imageSize) {
                    matrix.setToSaturation(if(pageOffset != 0.0f) 0f else 1f)
                }

                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .graphicsLayer {
                            scaleX = imageSize
                            scaleY = imageSize
                        },
                    model = ImageRequest.Builder(LocalContext.current).data(homePages[index].image).build(),
                    contentDescription = "Image",
                    contentScale = ContentScale.Crop,
                    colorFilter = ColorFilter.colorMatrix(matrix)
                )
            }
        }
    }
}

@Preview(showSystemUi = false)
@Composable
fun IntroScreenPreview() {
    HarryPotterTheme(true) {
        HomeScreen()
    }
}