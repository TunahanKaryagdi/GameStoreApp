package com.tunahankaryagdi.gamestoreapp.data

import com.tunahankaryagdi.gamestoreapp.data.model.Game
import com.tunahankaryagdi.gamestoreapp.data.model.GameDetail
import com.tunahankaryagdi.gamestoreapp.utils.Constants.HEADER_KEY
import com.tunahankaryagdi.gamestoreapp.utils.Constants.HEADER_VALUE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GameApi {
    @Headers(HEADER_KEY, HEADER_VALUE)
    @GET("/api/games")
    suspend fun getAll() : List<Game>

    @Headers(HEADER_KEY, HEADER_VALUE)
    @GET("/api/game")
    suspend fun getDetailById(@Query("id") id : String ) : GameDetail

}