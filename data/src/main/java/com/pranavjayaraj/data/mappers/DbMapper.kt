package com.pranavjayaraj.data.mappers

import com.pranavjayaraj.domain.models.entities.Photos
import com.pranavjayaraj.domain.models.PhotosResModel
import javax.inject.Inject

class DbMapper @Inject constructor() {
    fun toDbPhotos(photosResModel: ArrayList<PhotosResModel>?): ArrayList<Photos> {
        val photoList = ArrayList<Photos>()
        photosResModel?.forEach {
            photoList.add(
                Photos(
                    id = it.id ?: "",
                    owner = it.owner ?: "",
                    secret = it.secret ?: "",
                    server = it.server ?: "",
                    farm = it.farm ?: 0,
                    title = it.title ?: "",
                    page = it.page ?: 0
                )
            )
        }
        return photoList
    }

    fun toPhotosResModel(photos: ArrayList<Photos>): ArrayList<PhotosResModel>? {
        val photoResModel = ArrayList<PhotosResModel>()
        photos.forEach {
            photoResModel.add(
                PhotosResModel(
                    id = it.id,
                    owner = it.owner,
                    secret = it.secret,
                    server = it.server,
                    farm = it.farm,
                    title = it.title,
                    page = it.page
                )
            )
        }
        return photoResModel
    }
}