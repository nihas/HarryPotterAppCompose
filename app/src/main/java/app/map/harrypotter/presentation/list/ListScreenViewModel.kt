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

    fun GetSelectedCharacters(value: Int){
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            harryPotterUseCases.selectCharacters(value).fold(
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
            ListScreenEvent.AllCharacters -> GetSelectedCharacters(0)
            ListScreenEvent.Students -> GetSelectedCharacters(1)
            ListScreenEvent.Staffs -> GetSelectedCharacters(2)
            ListScreenEvent.Houses -> GetSelectedCharacters(3)
            ListScreenEvent.Spells -> getSpells()
        }
    }

    private fun getSpells() {
        state.value = state.value.copy(isLoading = true)
        viewModelScope.launch {
            harryPotterUseCases.getSpells().fold(
                onSuccess = {
                    state.value = state.value.copy(
                        isLoading = false,
                        spells = it,
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
}