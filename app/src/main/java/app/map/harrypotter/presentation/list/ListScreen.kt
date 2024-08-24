package app.map.harrypotter.presentation.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import app.map.harrypotter.domain.common.toError
import app.map.harrypotter.presentation.CharacterCard
import app.map.harrypotter.presentation.component.ErrorScreen
import com.bikcodeh.newsapp.ui.component.LoadingScreen
import kotlin.reflect.KFunction1

@Composable
fun ListScreen(
    event: KFunction1<ListScreenEvent, Unit>,
    viewModel: ListScreenViewModel
) {
// Collect the characters Flow as State
//    val charactersState by viewModel.characters.collectAsState()
    val mainState by viewModel.state

    LaunchedEffect(key1 = true) {
        viewModel.getCharacters()
    }

    if (mainState.isLoading) {
        LoadingScreen()
    }

    mainState.error?.let {
        ErrorScreen(error = it.toError())
    }

    LazyColumn(modifier = Modifier.testTag("LazyColumnArticlesHome")) {
        items(mainState.characters?.count() ?: 0) { index ->
            mainState.characters?.get(index)?.let {
                CharacterCard(item = it, onClick = {
//                    navController.navigate(Screen.Detail.passNewsIndex(index))
                })
            }
        }
    }
}

//@Composable
//fun CharacterCard(name: String, description: String, image: String) {
//    Card(
//        modifier = Modifier
//            .padding(10.dp)
//            .fillMaxWidth()
//            .wrapContentHeight(),
//        shape = MaterialTheme.shapes.medium,
//        elevation = CardDefaults.cardElevation(),
////        cardColor = MaterialTheme.colors.surface
//    ) {
//        Row(
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//            AsyncImage(
//                modifier = Modifier.size(130.dp).padding(8.dp),
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data(image)
//                    .crossfade(true)
//                    .scale(Scale.FILL)
//                    .build(),
//                contentDescription = "Image",
//                contentScale = ContentScale.Crop
//            )
//
//            Column(Modifier.padding(8.dp)) {
//                Text(
//                    text = name,
//                    style = MaterialTheme.typography.headlineMedium,
//                    color = MaterialTheme.colorScheme.background,
//                )
//                Text(
//                    text = description,
//                    style = MaterialTheme.typography.bodyMedium,
//                )
//            }
//        }
//    }
//}