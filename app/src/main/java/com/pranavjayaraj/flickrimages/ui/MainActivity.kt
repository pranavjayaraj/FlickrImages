package com.pranavjayaraj.flickrimages.ui

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.jakewharton.rxbinding2.view.RxView
import com.pranavjayaraj.domain.models.PhotosResModel
import com.pranavjayaraj.flickrimages.base.BaseActivity
import com.pranavjayaraj.flickrimages.base.BaseAdapterItemClick
import com.pranavjayaraj.flickrimages.databinding.ActivityMainBinding
import com.pranavjayaraj.flickrimages.ui.adapters.PhotosAdapter
import com.pranavjayaraj.flickrimages.utils.EndlessScrollListenerRv
import com.pranavjayaraj.flickrimages.utils.getViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(),
    BaseAdapterItemClick<PhotosResModel> {

    lateinit var photosAdapter: PhotosAdapter

    var key = ""

    private lateinit var endlessScrollListener: EndlessScrollListenerRv

    override fun getViewModelInstance(): MainViewModel {
        return viewModelFactory.getViewModel(this)
    }

    override fun getBindings(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onViewCreated() {
        super.onViewCreated()
        getPhotoList()
    }

    private fun getPhotoList() {
        viewModel.getCachedPhotoList(key)
    }

    override fun initializeAdapter() {
        super.initializeAdapter()
        initScrollListeners()
        photosAdapter = PhotosAdapter(this, this, glideDelegate = glideUtil)
        var layoutManager = GridLayoutManager(this, 2)
        view.photosRv.layoutManager = layoutManager
        view.photosRv.adapter = photosAdapter
    }

    override fun initializeObservers() {
        super.initializeObservers()
        viewModel.observerPhotoList().observe(this, Observer {
            if (it.isNullOrEmpty()) {
                endlessScrollListener.retry()
            } else {
                if (view.swipeRefreshLayout.isRefreshing) {
                    endlessScrollListener.reset()
                    photosAdapter.resetData(it)
                } else {
                    photosAdapter.setData(it)
                }
            }
            view.swipeRefreshLayout.isRefreshing = false
        })
    }

    override fun initializeClickListeners() {
        super.initializeClickListeners()
        view.swipeRefreshLayout.setOnRefreshListener {
            refresh()
        }
        RxView.clicks(addKey)
            .throttleFirst(1, TimeUnit.SECONDS)
            .subscribe {
                key = keyword.text.toString()
                refresh()
            }.let { }
    }

    private fun refresh() {
        view.swipeRefreshLayout.isRefreshing = true
        viewModel.getPhotoListFromServer(1, true,key)
    }

    private fun initScrollListeners() {
        endlessScrollListener = object : EndlessScrollListenerRv() {
            override fun onLoadMore() {
                try {
                    photosAdapter.getPhotosList().lastOrNull()?.page?.let {
                        viewModel.getPhotoListFromServer(it + 1,text = key)
                    }
                } catch (e: Exception) {

                }
            }
        }
        view.photosRv.addOnScrollListener(endlessScrollListener)
    }
}