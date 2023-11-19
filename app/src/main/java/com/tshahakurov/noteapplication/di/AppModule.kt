package com.tshahakurov.noteapplication.di

import android.content.Context
import androidx.room.Room
import com.tshahakurov.noteapplication.db.AppDataBase
import com.tshahakurov.noteapplication.db.NoteDao
import com.tshahakurov.noteapplication.util.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext app: Context): AppDataBase{
        return Room.databaseBuilder(
            app, AppDataBase::class.java, Util.DATA_BASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(appDB: AppDataBase): NoteDao {
        return appDB.getNoteDao()
    }
}