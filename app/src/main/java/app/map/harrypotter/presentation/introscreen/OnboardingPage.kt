package app.map.harrypotter.presentation.introscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import app.map.harrypotter.R
import app.map.harrypotter.ui.theme.HarryPotterTheme
import app.map.harrypotter.utils.Constants.mediumPadding1
import app.map.harrypotter.utils.Constants.mediumPadding2

@Composable
fun OnboardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.7f),
            painter = painterResource(id = page.image),
            contentDescription = page.title,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = modifier.height(mediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = mediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small),
        )
        Text(
            text = page.desc,
            modifier = Modifier.padding(horizontal = mediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun OnboardingPagePreview() {
    HarryPotterTheme {
        OnboardingPage(page = pages[0])
    }
}