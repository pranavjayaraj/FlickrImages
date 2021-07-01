package com.pranavjayaraj.data.db

import android.util.Log
import com.pranavjayaraj.data.mappers.DbMapper
import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.domain.models.entities.Photos
import com.pranavjayaraj.domain.repository.DbRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class DbRepositoryImpl @Inject constructor(
    val photosDao: PhotosDao,
    val dbMapper: DbMapper
) : DbRepository {

    override fun getPhotoList(): Single<ArrayList<PhotosResModel>?> {
        return photosDao.getPhotos().map {
            dbMapper.toPhotosResModel(ArrayList(it))
        }
    }

    override fun deleteAllPhotos(): Completable{
        Log.d("[DELETING PHOTOS]","[DELETING PHOTOS]")
        return photosDao.deleteAllPhotos()
    }

    override fun insertPhotoList(photosResModel: ArrayList<PhotosResModel>?): Completable {
        return photosDao.insertPhotos(dbMapper.toDbPhotos(photosResModel))
    }
}