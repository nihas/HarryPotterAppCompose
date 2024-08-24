package app.map.harrypotter.presentation.list

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.map.harrypotter.domain.common.fold
import app.map.harrypotter.domain.usecases.characters.GetCharacters
import app.map.harrypotter.domain.usecases.characters.HarryPotterUseCases
import app.map.harrypotter.presentation.home.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val harryPotterUseCases: HarryPotterUseCases
):ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    fun getCharacters(){
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            harryPotterUseCases.getCharacters().fold(
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

    fun selectedCharacters(value: Int){
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            harryPotterUseCases.selectArticle(value).fold(
                onSuccess = {

                },
                onFailure = {

                }
            )
        }
    }

    fun onEvent(event: ListScreenEvent){
        when(event){
            ListScreenEvent.AllCharacters -> getCharacters()
            ListScreenEvent.Houses -> getCharacters()
            ListScreenEvent.Spells -> getCharacters()
            ListScreenEvent.Staffs -> getCharacters()
            ListScreenEvent.Students -> getStudents()
        }
    }

    private fun getStudents() {
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            harryPotterUseCases.getStudents().fold(
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

    private fun updateScrollValue(newValue: Int){
//        state.value = state.value.copy(scrollValue = newValue)
    }
}