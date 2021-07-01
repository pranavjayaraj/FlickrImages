package com.pranavjayaraj.data.services

import com.pranavjayaraj.domain.models.PhotosDataRemoteResModel
import io.reactivex.Single
import retrofit2.http.*

interface ApiService {
    @GET(Urls.GET_PHOTO_LIST)
    fun getPhotos(@QueryMap data: Map<String?, @JvmSuppressWildcards Any?> ): Single<PhotosDataRemoteResModel?>
}