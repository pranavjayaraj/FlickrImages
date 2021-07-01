package com.pranavjayaraj.domain.interactors

import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.domain.repository.DbRepository
import com.pranavjayaraj.domain.types.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCachedPhotoListUseCase @Inject constructor(val dbRepository: DbRepository) :
    SingleUseCase<ArrayList<PhotosResModel>?> {
    override fun execute(): Single<ArrayList<PhotosResModel>?> {
        return dbRepository.getPhotoList()
    }
}