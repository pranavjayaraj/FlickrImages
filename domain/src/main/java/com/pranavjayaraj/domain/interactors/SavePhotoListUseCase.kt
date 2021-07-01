package com.pranavjayaraj.domain.interactors

import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.domain.repository.DbRepository
import com.pranavjayaraj.domain.types.CompletableUseCaseWithParam
import io.reactivex.Completable
import javax.inject.Inject

class SavePhotoListUseCase @Inject constructor(
    val dbRepository: DbRepository
) : CompletableUseCaseWithParam<ArrayList<PhotosResModel>?> {
    override fun execute(param: ArrayList<PhotosResModel>?): Completable {
        return dbRepository.insertPhotoList(param)
    }
}