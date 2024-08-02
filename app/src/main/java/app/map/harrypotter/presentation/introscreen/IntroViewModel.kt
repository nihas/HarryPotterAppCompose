package app.map.harrypotter.presentation.introscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.map.harrypotter.domain.usecases.appentry.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroViewModel @Inject constructor(
    private val saveAppEntry: SaveAppEntry
): ViewModel() {

    fun onEvent(event: IntroEvent){
        when(event){
            is IntroEvent.SaveAppEntry ->{
                saveUserEntry()
            }
        }
    }

    private fun saveUserEntry() {
        viewModelScope.launch {
            saveAppEntry()
        }
    }
}