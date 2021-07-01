package com.pranavjayaraj.flickrimages.base

import com.pranavjayaraj.flickrimages.di.AppComponent
import com.pranavjayaraj.flickrimages.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FlickerImagesApplication : DaggerApplication() {

    lateinit var appComponent: AppComponent

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        appComponent = DaggerAppComponent.builder().application(this).build()
        return appComponent
    }
}