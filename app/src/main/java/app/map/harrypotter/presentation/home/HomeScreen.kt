package app.map.harrypotter.presentation.home

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import androidx.compose.ui.unit.sp
import app.map.harrypotter.R
import app.map.harrypotter.presentation.introscreen.homePages
import app.map.harrypotter.ui.theme.HarryPotterTheme
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import kotlin.math.absoluteValue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(){
    val CustomFontFamily = FontFamily(
        Font(R.font.harryp)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(20.dp),
            text = "Harry Potter",
            color = MaterialTheme.colorScheme.primary,
            style = TextStyle(fontSize= 60.sp),
            fontFamily = CustomFontFamily
        )
        val pagerState = rememberPagerState(initialPage = 0) { homePages.size }
        val matrix = remember {
            ColorMatrix()
        }

        Scaffold(modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 0.dp)) {

            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(50.dp)
            ) {index ->
                SingleCardView(index,pagerState,matrix)
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SingleCardView(index: Int, pagerState: PagerState, matrix: ColorMatrix) {
    val pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffsetFraction
    val imageSize by animateFloatAsState(
        targetValue = if (pageOffset != 0.0f) 0.75f else 1f,
        animationSpec = tween(durationMillis = 300)
    )

    LaunchedEffect(key1 = imageSize) {
        matrix.setToSaturation(if(pageOffset != 0.0f) 0f else 1f)
    }

    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(2.dp).graphicsLayer {
            lerp(
                start = 0.85f.dp,
                stop = 1f.dp,
                fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
            ).also { scale ->
                scaleX = scale.value
                scaleY = scale.value
            }
            alpha = lerp(
                start = 0.50f.dp,
                stop = 1f.dp,
                fraction = 1f - pageOffset.absoluteValue.coerceIn(0f, 1f)
            ).value
        }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = ImageRequest.Builder(LocalContext.current)
                .data(homePages[index].image)
                .crossfade(true)
                .scale(Scale.FILL)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
            colorFilter = ColorFilter.colorMatrix(matrix)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun IntroScreenPreview() {
    HarryPotterTheme(true) {
        HomeScreen()
    }
}