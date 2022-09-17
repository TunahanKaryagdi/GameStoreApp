package com.tunahankaryagdi.gamestoreapp.di

import com.tunahankaryagdi.gamestoreapp.data.GameApi
import com.tunahankaryagdi.gamestoreapp.data.repository.GameRepository
import com.tunahankaryagdi.gamestoreapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object Module {


    @Provides
    @Singleton
    fun provideRetrofit(): GameApi {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GameApi::class.java)

    }

    @Provides
    @Singleton
    fun provideRepository(api : GameApi)  = GameRepository(api)




}