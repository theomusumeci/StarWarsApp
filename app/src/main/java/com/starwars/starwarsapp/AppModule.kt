package com.starwars.starwarsapp

import androidx.room.Room
import com.starwars.db.StarWarsDB
import com.starwars.dao.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
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