package com.example.wordsfactory.project.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wordsfactory.project.domain.UseCases.SearchWordUseCase
import com.example.wordsfactory.project.network.WordInformation

import kotlinx.coroutines.*

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