package com.starwars.home.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.starwars.home.data.Character

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCharacters(characters: List<Character>)

    @Query("SELECT * FROM Character")
    fun getAllCharacters(): List<Character>

    @Query("DELETE FROM Character")
    fun deleteAllCharacters()

    @Query("DELETE FROM Character WHERE id ==:id")
    fun deleteCharacterById(id: Int)

    @Query("SELECT * FROM Character WHERE id ==:id")
    fun getCharacterById(id: Int): Character
}