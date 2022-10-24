package com.example.wordsfactory.project.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.wordsfactory.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchBinding
    private lateinit var viewModelSearch: SearchActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewModelProvider(
            this,
            SearchActivityViewModelFactory()
        )[SearchActivityViewModel::class.java].also { viewModelSearch = it }

        viewModelSearch.liveData.observe(this, Observer {
            binding.word.text = it[0].wordName
            binding.transcription.text = it[0].phonetics[0].transcription
            binding.partOfSpeech.text = it[0].meanings[0].partOfSpeech
        })

        binding.searchWordLayout.setEndIconOnClickListener {
            val word: String = binding.searchWordEdit.text.toString()

            viewModelSearch.searchWord(word = word)
        }
    }
}