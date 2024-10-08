package app.map.harrypotter.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import app.map.harrypotter.domain.model.CharactersItem
import app.map.harrypotter.ui.theme.HarryPotterTheme
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun CharacterCard(
    modifier: Modifier = Modifier,
    item: CharactersItem,
    onClick: (() -> Unit)? = null
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            // Profile Image
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(item.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp) // Adjust size as needed
                    .background(MaterialTheme.colorScheme.surface) // Optional: to add background color
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Title and Description
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    text = item.name ?: String(),
                    style = MaterialTheme.typography.titleMedium,
                    fontSize = 20.sp // Adjust font size as needed
                )
                Text(
                    text = item.house ?: String(),
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 16.sp // Adjust font size as needed
                )
            }
        }
    }


//    Card(
//        modifier = Modifier
//            .padding(10.dp)
//            .fillMaxWidth()
//            .wrapContentHeight(),
//        shape = MaterialTheme.shapes.medium,
//        elevation = CardDefaults.cardElevation(),
////        cardColor = MaterialTheme.colors.surface
//    ) {
//
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//            AsyncImage(
//                modifier = Modifier.size(130.dp).padding(8.dp),
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(item.image)
//                    .crossfade(true)
//                    .scale(Scale.FILL)
//                    .build(),
//                contentDescription = "Image",
//                contentScale = ContentScale.Crop
//            )
//
//            Column(Modifier.padding(8.dp)) {
//                Text(
//                    text = item.name ?: "",
//                    style = MaterialTheme.typography.headlineMedium,
//                    color = MaterialTheme.colorScheme.background,
//                )
//                Text(
//                    text = item.patronus ?: "",
//                    style = MaterialTheme.typography.bodyMedium,
//                )
//            }
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    HarryPotterTheme(dynamicColor = false) {
        CharacterCard(
            item= CharactersItem(
                name = "Hello",
                image = "https://ichef.bbci.co.uk/live-experience/cps/624/cpsprodpb/11787/production/_124395517_bbcbreakingnewsgraphic.jpg",
                patronus = "Haa"
            )
        )
    }
}