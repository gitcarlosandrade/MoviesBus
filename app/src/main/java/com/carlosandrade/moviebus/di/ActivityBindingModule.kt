package com.carlosandrade.moviebus.di

import com.carlosandrade.moviebus.view.activity.MoviesListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector(modules = [MoviesListModule::class])
    abstract fun MoviesListActivity(): MoviesListActivity
}
