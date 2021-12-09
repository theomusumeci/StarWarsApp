package com.starwars.repository.home

import com.starwars.home.dao.CharacterDao
import com.starwars.home.data.Character
import javax.inject.Inject
import javax.inject.Singleton

interface CharacterRepository {
    fun getCharacterById(id: Int): Character
    fun saveCharacters(characters: List<Character>)
    fun deleteAllCharacters()
    fun deleteCharterById(id: Int)
    fun getAllCharacters(): List<Character>
}

@Singleton
class CharacterRepositoryImpl @Inject constructor(private val characterDao: CharacterDao) :
    CharacterRepository {

    override fun getCharacterById(id: Int): Character = characterDao.getCharacterById(id)

    override fun saveCharacters(characters: List<Character>) =
        characterDao.saveCharacters(characters)

    override fun deleteAllCharacters() = characterDao.deleteAllCharacters()

    override fun deleteCharterById(id: Int) = characterDao.deleteCharacterById(id)

    override fun getAllCharacters(): List<Character> = characterDao.getAllCharacters()
}