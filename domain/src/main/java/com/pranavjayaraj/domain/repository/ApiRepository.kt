package com.pranavjayaraj.domain.repository

import com.pranavjayaraj.domain.models.PhotosResModel
import io.reactivex.Single

interface ApiRepository {
    fun getPhotoList(param:Map<String?, Any?>): Single<ArrayList<PhotosResModel>?>
}