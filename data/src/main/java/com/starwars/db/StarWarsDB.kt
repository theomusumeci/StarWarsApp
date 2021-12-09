package com.starwars.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.starwars.home.dao.CharacterDao
import com.starwars.home.data.Character

@Database(entities = [Character::class], version = 1, exportSchema = false)
abstract class StarWarsDB : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

    companion object {
        const val DATABASE_NAME: String = "star-wars-db"
    }
}
