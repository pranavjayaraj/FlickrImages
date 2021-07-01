package com.pranavjayaraj.flickrimages.ui

import androidx.lifecycle.MutableLiveData
import com.pranavjayaraj.domain.SchedulerProvider
import com.pranavjayaraj.domain.interactors.DeleteAllPhotosUseCase
import com.pranavjayaraj.domain.interactors.FetchPhotoListUseCase
import com.pranavjayaraj.domain.interactors.GetCachedPhotoListUseCase
import com.pranavjayaraj.domain.interactors.SavePhotoListUseCase
import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.flickrimages.base.BaseViewModel
import io.reactivex.rxkotlin.addTo
import javax.inject.Inject

class MainViewModel @Inject constructor(
    schedulersFacade: SchedulerProvider,
    private val getCachedPhotoListUseCase: GetCachedPhotoListUseCase,
    private val savePhotoListUseCase: SavePhotoListUseCase,
    private val fetchPhotoListUseCase: FetchPhotoListUseCase,
    private val deleteAllPhotosUseCase: DeleteAllPhotosUseCase
) : BaseViewModel(schedulersFacade) {

    private val observePhotos = MutableLiveData<ArrayList<PhotosResModel>?>()

    fun observerPhotoList(): MutableLiveData<ArrayList<PhotosResModel>?> {
        return observePhotos
    }

    fun getCachedPhotoList(key:String) {
        getCachedPhotoListUseCase.execute()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe({
                if (!it.isNullOrEmpty()) {
                    observePhotos.postValue(it)
                } else {
                    getPhotoListFromServer(1, true,key)
                }
            }, {
            }).addTo(getCompositeDisposable())
    }

    fun getPhotoListFromServer(page: Int, delete: Boolean = false,text:String?) {
        val map = mutableMapOf<String?, Any?>()
        map["text"] = text
        map["perpage"] = 5
        map["page"] = page
        fetchPhotoListUseCase.execute(map)
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe({
                observePhotos.postValue(ArrayList(it))
                savePhotoListToCache(it, delete)
            }, {
                observePhotos.postValue(null)
            }).addTo(getCompositeDisposable())
    }

    private fun savePhotoListToCache(photoList: ArrayList<PhotosResModel>?, isDeletable: Boolean) {
        deleteAllPhotosUseCase.execute(isDeletable)
            .concatWith(savePhotoListUseCase.execute(photoList))
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())
            .subscribe({
            }, {

            }).addTo(getCompositeDisposable())
    }
}