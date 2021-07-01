package com.pranavjayaraj.data.db

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import com.pranavjayaraj.domain.Utils
import com.pranavjayaraj.domain.repository.DbRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun provideDataBase(application: Application): AppDataBase {
        return Room.databaseBuilder(
            application,
            AppDataBase::class.java, Utils.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePhotosDao(appDataBase: AppDataBase): PhotosDao {
        return appDataBase.photosDao()
    }
}