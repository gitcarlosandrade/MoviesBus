package com.carlosandrade.moviebus.di

import com.carlosandrade.moviebus.repository.MoviesRepository
import com.carlosandrade.moviebus.repository.MoviesRepositoryImpl
import com.carlosandrade.moviebus.presenter.movies.MoviesListContract
import com.carlosandrade.moviebus.presenter.movies.MoviesListPresenterImpl
import com.carlosandrade.moviebus.repository.remote.RemoteDataSource
import com.carlosandrade.moviebus.repository.remote.RemoteDataSourceImpl
import com.carlosandrade.moviebus.view.activity.MoviesListActivity
import dagger.Binds
import dagger.Module

@Module
abstract class MoviesListModule {

    @Binds
    abstract fun provideMoviesListPresenter(impl: MoviesListPresenterImpl) : MoviesListContract.Presenter

    @Binds
    abstract fun provideMoviesListView(impl: MoviesListActivity) : MoviesListContract.View

    @Binds
    abstract fun provideMoviesModel(impl: MoviesRepositoryImpl) : MoviesRepository

    @Binds
    abstract fun provideRemoteDataSource(impl: RemoteDataSourceImpl) : RemoteDataSource
}
