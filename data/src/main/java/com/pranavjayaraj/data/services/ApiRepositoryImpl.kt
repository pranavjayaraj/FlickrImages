package com.pranavjayaraj.data.services

import com.pranavjayaraj.data.mappers.PhotosDataMapper
import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.domain.repository.ApiRepository
import io.reactivex.Single
import javax.inject.Inject

class ApiRepositoryImpl @Inject constructor(
    val apiService: ApiService,
    private val photosMapper: PhotosDataMapper
) : ApiRepository {
    override fun getPhotoList(param: Map<String?, Any?>): Single<ArrayList<PhotosResModel>?> {
        return apiService.getPhotos(param).map {
            photosMapper.toPhotoResModel(it)
        }
    }
}