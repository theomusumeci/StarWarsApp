package com.starwars.repository

import com.starwars.dao.CharacterDao
import com.starwars.data.Character
import com.starwars.data.Characters
import com.starwars.db.StarWarsDB
import com.starwars.networking.Resource
import com.starwars.networking.networkBoundResource
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
class CharacterRepository @Inject constructor(
    private val characterDao: CharacterDao,
    private val characterDataSourceProvider: CharacterDataSourceProvider,
) {

    fun getCharacters(): Flow<Resource<Characters>> = networkBoundResource(
        { characterDao.getCharacters() },
        { characterDataSourceProvider.getCharacters() },
        { characters ->
            characterDao.updateCharcaters(characters)
        }
    )

    fun getCharacterById(id: Int): Character = characterDao.getCharacterById(id)

    fun saveCharacters(characters: Characters) =
        characterDao.saveCharacters(characters)

    fun deleteAllCharacters() = characterDao.deleteCharacters()

    fun deleteCharterById(id: Int) = characterDao.deleteCharacterById(id)

    fun getAllCharacters(): Flow<Characters> = characterDao.getCharacters()
}