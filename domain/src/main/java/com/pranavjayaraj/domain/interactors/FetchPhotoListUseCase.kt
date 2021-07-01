package com.pranavjayaraj.domain.interactors

import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.domain.repository.ApiRepository
import com.pranavjayaraj.domain.types.SingleUseCaseWithParam
import io.reactivex.Single
import javax.inject.Inject

class FetchPhotoListUseCase @Inject constructor(private val apiRepository: ApiRepository) :
    SingleUseCaseWithParam<Map<String?, Any?>, ArrayList<PhotosResModel>?> {
    override fun execute(param: Map<String?, Any?>): Single<ArrayList<PhotosResModel>? > {
        return apiRepository.getPhotoList(param)
    }
}