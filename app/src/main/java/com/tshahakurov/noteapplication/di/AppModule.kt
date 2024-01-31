package com.tshahakurov.noteapplication.di

import android.content.Context
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
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
    fun provideDB(@ApplicationContext app: Context): AppDataBase {
        val migration1to2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL(
                    "alter table ${Util.NOTE_TABLE_NAME} add column ${Util.BOOKMARK_COLUMN_NAME} integer not null default 0"
                )
            }
        }

        return Room
            .databaseBuilder(app, AppDataBase::class.java, Util.DATA_BASE_NAME)
            .addMigrations(migration1to2)
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(appDB: AppDataBase): NoteDao {
        return appDB.getNoteDao()
    }
}