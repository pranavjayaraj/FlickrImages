package com.pranavjayaraj.flickrimages.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pranavjayaraj.flickrimages.ui.MainViewModel
import com.pranavjayaraj.flickrimages.common.ViewModelFactory
import com.pranavjayaraj.flickrimages.common.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun providesMainViewModel(viewModel: MainViewModel): ViewModel
}