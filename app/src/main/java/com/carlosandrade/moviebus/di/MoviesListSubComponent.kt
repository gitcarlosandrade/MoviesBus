package com.carlosandrade.moviebus.di

import com.carlosandrade.moviebus.view.activity.MoviesListActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MoviesListModule::class])
interface MoviesListSubComponent : AndroidInjector<MoviesListActivity> {

    @Subcomponent.Factory
    interface Builder : AndroidInjector.Factory<MoviesListActivity>
}