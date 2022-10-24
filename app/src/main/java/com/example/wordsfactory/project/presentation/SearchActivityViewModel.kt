package com.example.wordsfactory.project.presentation

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordsfactory.project.domain.UseCases.SearchWordUseCase
import com.example.wordsfactory.project.network.BASE_URL
import com.example.wordsfactory.project.network.SearchWordsService
import com.example.wordsfactory.project.network.WordInformation
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class SearchActivityViewModel(
    private val searchWordUseCase: SearchWordUseCase,
) : ViewModel() {
    val liveData = MutableLiveData<List<WordInformation>>()

    init {
        viewModelScope.launch {
            val test = searchWordUseCase.execute(word = "test")
        }
    }

    fun searchWord(word: String) {
        viewModelScope.launch {
            liveData.value = searchWordUseCase.execute(word = word)
        }
    }
}