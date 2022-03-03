package com.starwars.starwarsapp.home.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.starwars.dao.CharacterDao
import com.starwars.repository.CharacterDataSource
import com.starwars.repository.CharacterRepository
import com.starwars.starwarsapp.R
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.HttpClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val datasource = CharacterDataSource(HttpClient())

        runBlocking {
            val characters = datasource.getCharacters()
            val character = datasource.getCharacter(1)
        }

    }
}