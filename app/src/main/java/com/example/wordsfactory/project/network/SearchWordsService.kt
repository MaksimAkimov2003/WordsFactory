package com.example.wordsfactory.project.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.dictionaryapi.dev/api/v2/entries/en/"

interface SearchWordsService {
    @GET(value = "{word}")
    suspend fun getWordInformation(
        @Path(value = "word")
        word: String
    ): List<WordInformation>
}

object SearchWordAPI {
    lateinit var searchWordsService: SearchWordsService

    init {
        configureRetrofit()
    }

    private fun configureRetrofit() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        searchWordsService = retrofit.create(SearchWordsService::class.java)
    }
}