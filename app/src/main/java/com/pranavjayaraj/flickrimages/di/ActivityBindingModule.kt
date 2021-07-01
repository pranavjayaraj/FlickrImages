package com.pranavjayaraj.flickrimages.di

import com.pranavjayaraj.flickrimages.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ViewModelModule::class])
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun providesMainActivity():MainActivity
}
