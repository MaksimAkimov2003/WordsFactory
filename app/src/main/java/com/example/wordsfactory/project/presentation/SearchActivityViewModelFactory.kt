package com.example.wordsfactory.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wordsfactory.project.data.WordsRepositoryImpl
import com.example.wordsfactory.project.domain.UseCases.SearchWordUseCase

class SearchActivityViewModelFactory() : ViewModelProvider.Factory {
    private val wordsRepository by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        WordsRepositoryImpl()
    }

    private val searchWordUseCase by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
        SearchWordUseCase(wordsRepository = wordsRepository)
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchActivityViewModel(searchWordUseCase = searchWordUseCase) as T
    }
}