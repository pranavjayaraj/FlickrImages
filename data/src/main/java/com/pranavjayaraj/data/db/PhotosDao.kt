package com.pranavjayaraj.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pranavjayaraj.domain.models.entities.Photos
import com.pranavjayaraj.domain.models.entities.Photos.Companion.TABLE
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface PhotosDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhotos(photos: List<Photos>):Completable

    @Query("select * from $TABLE")
    fun getPhotos(): Single<List<Photos>>

    @Query("delete from $TABLE")
    fun deleteAllPhotos(): Completable
}