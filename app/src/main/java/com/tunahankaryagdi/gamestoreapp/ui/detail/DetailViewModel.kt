package com.tunahankaryagdi.gamestoreapp.ui.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunahankaryagdi.gamestoreapp.data.model.GameDetail
import com.tunahankaryagdi.gamestoreapp.data.repository.GameRepository
import com.tunahankaryagdi.gamestoreapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: GameRepository) : ViewModel(){

    var gameDetail: MutableLiveData<GameDetail?> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData(true)
    var error: MutableLiveData<String> = MutableLiveData()


    fun getDetailById(id: String) {

        loading.value = true
        viewModelScope.launch {

            when (val result = repository.getGameById(id)) {

                is Resource.Success -> {
                    gameDetail.value = result!!.data
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