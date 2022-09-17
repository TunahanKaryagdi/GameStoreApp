package com.tunahankaryagdi.gamestoreapp.data.repository

import com.tunahankaryagdi.gamestoreapp.data.GameApi
import com.tunahankaryagdi.gamestoreapp.data.model.Game
import com.tunahankaryagdi.gamestoreapp.utils.Resource
import javax.inject.Inject


class GameRepository @Inject constructor(private val api: GameApi) {

    suspend fun getAllGame(): Resource<List<Game>> {
        val response = try {
            api.getAll()

        } catch (e: Exception) {
            return Resource.Error(e.localizedMessage)

        }
        return Resource.Success(response)
    }
}