package com.tunahankaryagdi.gamestoreapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunahankaryagdi.gamestoreapp.data.model.Game
import com.tunahankaryagdi.gamestoreapp.data.repository.GameRepository
import com.tunahankaryagdi.gamestoreapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: GameRepository) : ViewModel() {

    var gameList: MutableLiveData<List<Game>> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData(true)
    var error: MutableLiveData<String> = MutableLiveData()


    init {
        getAll()
    }

    fun getAll() {
        loading.value = true
        viewModelScope.launch {

            when (val result = repository.getAllGame()) {

                is Resource.Success -> {
                    gameList.value = result.data!!
                    error.value = ""
                    loading.value = false
                }

                is Resource.Error -> {
                    error.value = result.message!!
                    loading.value = false
                }

                else -> {}
            }
        }
    }
}