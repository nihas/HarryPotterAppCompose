package app.map.harrypotter.presentation.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import app.map.harrypotter.domain.common.toError
import app.map.harrypotter.presentation.CharacterCard
import app.map.harrypotter.presentation.SpellsCard
import app.map.harrypotter.presentation.component.ErrorScreen
import com.bikcodeh.newsapp.ui.component.LoadingScreen
import kotlin.reflect.KFunction1

@Composable
fun ListScreen(
    event: KFunction1<ListScreenEvent, Unit>,
    viewModel: ListScreenViewModel,
    selectedCardIndex: Int
) {
    // Collect the characters Flow as State
    val mainState by viewModel.state

    LaunchedEffect(key1 = true) {
        when(selectedCardIndex){
            0 -> event(ListScreenEvent.AllCharacters)
            1 -> event(ListScreenEvent.Students)
            2 -> event(ListScreenEvent.Staffs)
            3 -> event(ListScreenEvent.Houses)
            4 -> event(ListScreenEvent.Spells)
        }
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
        items(mainState.spells?.count() ?: 0) { index ->
            mainState.spells?.get(index)?.let {
                SpellsCard(item = it, onClick = {
//                    navController.navigate(Screen.Detail.passNewsIndex(index))
                })
            }
        }
    }
}