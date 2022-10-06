package com.example.wordsfactory.project.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wordsfactory.project.domain.UseCases.SearchWordUseCase
import com.example.wordsfactory.project.domain.models.WordInformationModel

class SearchActivityViewModel(
    private val searchWordUseCase: SearchWordUseCase
) : ViewModel() {
    val liveData = MutableLiveData<WordInformationModel>()

    fun searchWord(word: String) {
        val wordInfo = searchWordUseCase.execute(word = word)
        liveData.value = wordInfo
    }
}