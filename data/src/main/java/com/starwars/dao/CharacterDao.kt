package com.starwars.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.starwars.data.Character
import com.starwars.data.Characters
import kotlinx.coroutines.flow.Flow

@Dao
interface CharacterDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCharacters(characters: Characters)

    @Query("SELECT * FROM Character")
    fun getCharacters(): Flow<Characters>

    @Query("DELETE FROM Character")
    fun deleteCharacters()

    @Query("DELETE FROM Character WHERE id ==:id")
    fun deleteCharacterById(id: Int)

    @Query("SELECT * FROM Character WHERE id ==:id")
    fun getCharacterById(id: Int): Character

    @Transaction
    fun updateCharcaters(characters: Characters) {
        // TODO hace falta el delete? Digo poro el OnConflictStrategy dale save
        deleteCharacters()
        saveCharacters(characters)
    }
}