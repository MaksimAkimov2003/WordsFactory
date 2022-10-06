package com.example.wordsfactory.project.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.wordsfactory.databinding.ActivitySearchBinding
import com.example.wordsfactory.project.domain.models.WordInformationModel

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
            binding.word.text = it.wordName
            binding.transcription.text = it.wordTranscription
            binding.partOfSpeech.text = it.wordPartOfSpeech
        })

//        binding.textViewLayout.setEndIconOnClickListener {
//            Toast.makeText(this, "ALALA", Toast.LENGTH_LONG).show()
//        }
    }
}