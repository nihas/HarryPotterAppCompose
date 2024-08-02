package app.map.harrypotter.presentation.introscreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import app.map.harrypotter.R
import app.map.harrypotter.ui.theme.HarryPotterTheme
import app.map.harrypotter.ui.theme.Teal200
import app.map.harrypotter.utils.Constants.indicatorSize
import app.map.harrypotter.utils.Constants.mediumPadding2
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IntroScreen(
    event: (IntroEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        val pagerState = rememberPagerState(initialPage = 0) { pages.size }

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
            Box(modifier = Modifier.align(Alignment.CenterVertically)){
                BottomSection(pagerState,event)
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomSection(pagerState: PagerState, event: (IntroEvent) -> Unit) {
    Row(
        modifier = Modifier
            .padding(bottom = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = if (pagerState.currentPage != 2) Arrangement.SpaceBetween else Arrangement.Center
    ) {

        if (pagerState.currentPage == 2){
            OutlinedButton(
                onClick = { },
                shape = RoundedCornerShape(50), // = 40% percent
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier.padding(vertical = 8.dp, horizontal = 40.dp).clickable {
                        if(pagerState.currentPage == 2){
                            event(IntroEvent.SaveAppEntry)
                        }
                    },
                    color = Color.Gray
                )
            }
        }else{
            val scope = rememberCoroutineScope()
            BackNextButton("Back",Modifier.padding(start = 20.dp), onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(page = pagerState.currentPage - 1)
                }
            })
            PageIndicator(
                modifier = Modifier.width(50.dp),
                pageSize = pages.size,
                selectedPage = pagerState.currentPage
            )
            BackNextButton("Next",Modifier.padding(end = 20.dp), onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(page = pagerState.currentPage + 1)
                }
            })
        }

    }
}

@Composable
fun BackNextButton(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = colorResource(id = R.color.placeholder)
        )
    }
}

@Preview(showSystemUi = false)
@Composable
fun IntroScreenPreview() {
    HarryPotterTheme(true) {
//        IntroScreen()
    }
}