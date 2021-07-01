package com.pranavjayaraj.data.mappers

import com.pranavjayaraj.domain.models.PhotosDataRemoteResModel
import com.pranavjayaraj.domain.models.PhotosResModel
import javax.inject.Inject

class PhotosDataMapper @Inject constructor() {
    fun toPhotoResModel(photosDataRemoteResModel: PhotosDataRemoteResModel?): ArrayList<PhotosResModel>? {
        var photoResArrayList = ArrayList<PhotosResModel>()
        val page = photosDataRemoteResModel?.photosPageRemote?.page
        val photos = photosDataRemoteResModel?.photosPageRemote?.photos
        photos?.forEach {
            photoResArrayList.add(
                PhotosResModel(
                    id = it.id,
                    owner = it.owner,
                    secret = it.secret,
                    server = it.server,
                    farm = it.farm,
                    title = it.title,
                    page = page
                )
            )
        }
        return photoResArrayList
    }

}