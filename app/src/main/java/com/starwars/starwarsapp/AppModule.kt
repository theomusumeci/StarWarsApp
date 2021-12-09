package com.starwars.starwarsapp

import androidx.room.Room
import com.starwars.db.StarWarsDB
import com.starwars.home.dao.CharacterDao
import com.starwars.repository.home.CharacterRepository
import com.starwars.repository.home.CharacterRepositoryImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideStarWarsDB(app: StarWarsApp): StarWarsDB = Room
        .databaseBuilder(app, StarWarsDB::class.java, StarWarsDB.DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideCharacterDao(
        db: StarWarsDB
    ): CharacterDao = db.characterDao()

}