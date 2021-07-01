package com.pranavjayaraj.flickrimages.di

import com.pranavjayaraj.data.services.ApiRepositoryImpl
import com.pranavjayaraj.data.services.NetworkModule
import com.pranavjayaraj.data.SchedulersFacade
import com.pranavjayaraj.data.db.DbModule
import com.pranavjayaraj.data.db.DbRepositoryImpl
import com.pranavjayaraj.domain.SchedulerProvider
import com.pranavjayaraj.domain.repository.ApiRepository
import com.pranavjayaraj.domain.repository.DbRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module(includes = [NetworkModule::class, DbModule::class])
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun provideApiRepository(apiRepositoryImpl: ApiRepositoryImpl): ApiRepository

    @Binds
    @Singleton
    abstract fun provideSchedulerProvider(schedulersFacade: SchedulersFacade): SchedulerProvider

    @Binds
    @Singleton
    abstract fun provideChatDbRepository(dbRepository: DbRepositoryImpl): DbRepository
}