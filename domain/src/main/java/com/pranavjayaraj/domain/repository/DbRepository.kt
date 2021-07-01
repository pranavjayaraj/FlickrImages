package com.pranavjayaraj.domain.repository

import com.pranavjayaraj.domain.models.PhotosResModel
import io.reactivex.Completable
import io.reactivex.Single

interface DbRepository {
    fun getPhotoList(): Single<ArrayList<PhotosResModel>?>
    fun insertPhotoList(photosResModel: ArrayList<PhotosResModel>?): Completable
    fun deleteAllPhotos():Completable
}