package com.pranavjayaraj.domain.interactors

import com.pranavjayaraj.domain.repository.DbRepository
import com.pranavjayaraj.domain.types.CompletableUseCase
import com.pranavjayaraj.domain.types.CompletableUseCaseWithParam
import io.reactivex.Completable
import javax.inject.Inject

class DeleteAllPhotosUseCase @Inject constructor(private val dbRepository: DbRepository) :
    CompletableUseCaseWithParam<Boolean> {
    override fun execute(delete: Boolean): Completable {
        return if (!delete) {
            Completable.complete()
        } else {
            dbRepository.deleteAllPhotos()
        }
    }
}