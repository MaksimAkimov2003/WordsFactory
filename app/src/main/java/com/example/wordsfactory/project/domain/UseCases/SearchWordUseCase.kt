package com.example.wordsfactory.project.domain.UseCases

import com.example.wordsfactory.project.domain.repositories.WordsRepository
import com.example.wordsfactory.project.network.WordInformation

class SearchWordUseCase(private val wordsRepository: WordsRepository) {

    suspend fun execute(word: String): List<WordInformation> {
        return wordsRepository.getWordFromNetwork(word = word)
    }
}