package com.pranavjayaraj.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pranavjayaraj.domain.Utils
import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.domain.models.entities.Photos

@Database(entities = [Photos::class], version = Utils.DB_VERSION, exportSchema = false)
abstract class AppDataBase: RoomDatabase(){
    abstract fun photosDao():PhotosDao
}