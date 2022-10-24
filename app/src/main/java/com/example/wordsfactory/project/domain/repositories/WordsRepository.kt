package com.example.wordsfactory.project.domain.repositories

import com.example.wordsfactory.project.network.WordInformation

interface WordsRepository {
   suspend fun getWordFromNetwork(word: String): List<WordInformation>
}