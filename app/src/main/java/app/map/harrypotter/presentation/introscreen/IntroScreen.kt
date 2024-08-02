package app.map.harrypotter.presentation.introscreen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.map.harrypotter.R
import app.map.harrypotter.ui.theme.Grey300
import app.map.harrypotter.ui.theme.Grey900
import app.map.harrypotter.ui.theme.Teal200
import app.map.harrypotter.ui.theme.Typography
import app.map.harrypotter.utils.Constants.indicatorSize
import app.map.harrypotter.utils.Constants.mediumPadding2
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState(initialPage = 0) { pages.size }

        // Since button state depends on pager state, derivedState is used
        val buttonState = remember {
            derivedStateOf {
                when (pagerState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        // Used for Paging
        HorizontalPager(state = pagerState) { index ->
            OnboardingPage(page = pages[index])
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = mediumPadding2)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PageIndicator(
                modifier = Modifier.width(50.dp),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )

//            Row(verticalAlignment = Alignment.CenterVertically) {
//                val scope = rememberCoroutineScope()
//
//                if (buttonState.value[0].isNotEmpty()) {
//                    NewsTextButton(text = buttonState.value[0], onClick = {
//                        scope.launch {
//                            pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
//                        }
//                    })
//                }
//
//                NewsButton(text = buttonState.value[1], onClick = {
//                    scope.launch {
//                        if (pagerState.currentPage == 2) {
//                            event(OnboardingEvent.SaveAppEntry)
//                        } else {
//                            pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
//                        }
//                    }
//                })
//            }
            Box(modifier = Modifier.align(Alignment.CenterVertically)){
                BottomSection(pagerState.currentPage)
            }
        }

        Spacer(modifier = Modifier.weight(0.5f))
    }
}

@Composable
fun PageIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectedPage: Int,
    selectorColor: Color = Color.Blue,
    unselectedColor: Color = Teal200
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(modifier = Modifier.size(indicatorSize).clip(CircleShape).background(
                color = if (page == selectedPage) selectorColor else unselectedColor
            ))
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 25.dp else 10.dp)

    Box(
        modifier = Modifier
            .padding(1.dp)
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                if (isSelected) MaterialTheme.colorScheme.primary else Grey300.copy(alpha = 0.5f)
            )
    )
}

@Composable
fun BottomSection(currentPager: Int) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (currentPager != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {

        if (currentPager == 2){
            OutlinedButton(
                onClick = { },
                shape = RoundedCornerShape(50), // = 40% percent
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp),
                    color = Color.Gray
                )
            }
        }else{
            SkipNextButton("Skip",Modifier.padding(start = 20.dp))
            SkipNextButton("Next",Modifier.padding(end = 20.dp))
        }

    }
}

@Composable
fun SkipNextButton(text: String, modifier: Modifier) {
    Text(
        text = text, color = Grey300, modifier = modifier, fontSize = 18.sp,
        style = Typography.bodyMedium,
        fontWeight = FontWeight.Medium
    )

}