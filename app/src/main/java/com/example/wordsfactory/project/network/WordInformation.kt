package com.example.wordsfactory.project.network

import com.squareup.moshi.Json

data class WordInformation(
    @Json(name = "word") val wordName: String,
    @Json(name = "phonetics") val phonetics: List<Phonetics>,
    val meanings: List<Meanings>
)

data class Phonetics(
    @Json(name = "text") val transcription: String,
    @Json(name = "audio") val audio: String
)

data class Meanings(
    @Json(name = "partOfSpeech") val partOfSpeech: String
)