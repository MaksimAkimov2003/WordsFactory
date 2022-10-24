package com.example.wordsfactory.project.data

import com.example.wordsfactory.project.domain.repositories.WordsRepository
import com.example.wordsfactory.project.network.SearchWordAPI
import com.example.wordsfactory.project.network.WordInformation

class WordsRepositoryImpl : WordsRepository {
    override suspend fun getWordFromNetwork(word: String): List<WordInformation> {

        return SearchWordAPI.searchWordsService.getWordInformation(word = word)
    }
}