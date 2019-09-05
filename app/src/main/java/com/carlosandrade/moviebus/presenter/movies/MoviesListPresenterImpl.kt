package com.carlosandrade.moviebus.presenter.movies

import com.carlosandrade.moviebus.repository.MoviesRepository
import com.carlosandrade.moviebus.repository.entity.MostPopularMovies
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesListPresenterImpl @Inject constructor(
    val repository: MoviesRepository,
    val view: MoviesListContract.View?
) : MoviesListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun subscribe() {
        val disposable = repository.getMostPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleSuccess, this::handleError)

        compositeDisposable.add(disposable)
    }

    override fun unsubscribe() {
        compositeDisposable.clear()
    }

    override fun handleSuccess(mostPopularMovies: MostPopularMovies) {

    }

    override fun handleError(throwable: Throwable) {

    }
}