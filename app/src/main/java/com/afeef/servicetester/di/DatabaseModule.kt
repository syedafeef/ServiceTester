/*
package com.afeef.servicetester.di

import android.app.Application
import androidx.room.Room
import com.afeef.servicetester.data.local.CurrentDao
import com.afeef.servicetester.data.local.TestDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): TestDatabase = Room.databaseBuilder(app, TestDatabase::class.java, "current_db").build()

    @Provides
    @Singleton
    fun provideCurrentDao(db: TestDatabase): CurrentDao = db.currentDao()
}
*/
