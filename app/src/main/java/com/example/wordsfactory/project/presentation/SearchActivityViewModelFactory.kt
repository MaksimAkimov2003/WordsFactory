package com.example.wordsfactory.project.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.wordsfactory.project.domain.UseCases.SearchWordUseCase

class SearchActivityViewModelFactory() : ViewModelProvider.Factory {
    private val searchWordUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SearchWordUseCase()
    }

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchActivityViewModel(searchWordUseCase = searchWordUseCase) as T
    }
}