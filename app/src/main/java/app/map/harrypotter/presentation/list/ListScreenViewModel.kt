package app.map.harrypotter.presentation.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.map.harrypotter.domain.common.fold
import app.map.harrypotter.domain.usecases.characters.GetCharacters
import app.map.harrypotter.presentation.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharacters
):ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    fun getCharacters(){
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            getCharactersUseCase().fold(
                onSuccess = {
                    state.value = state.value.copy(
                        isLoading = false,
                        characters= it,
                        error = null
                    )
                },
                onFailure = {
                    state.value = state.value.copy(
                        isLoading = false,
                        error = it
                    )
                }
            )
        }
    }

    fun onEvent(event: ListScreenEvent){
        when(event){
            is ListScreenEvent.UpdateScrollValue -> updateScrollValue(event.newValue)
//            is ListScreenEvent.UpdateMaxScrollingValue -> updateScrollValue(event.newValue)
        }
    }

    private fun updateScrollValue(newValue: Int){
//        state.value = state.value.copy(scrollValue = newValue)
    }
}