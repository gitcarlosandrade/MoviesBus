package com.carlosandrade.moviebus.presenter.movies

import com.carlosandrade.moviebus.presenter.model.Movie
import com.carlosandrade.moviebus.repository.MoviesRepository
import com.carlosandrade.moviebus.repository.remote.response.MostPopularMoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MoviesListPresenterImpl @Inject constructor(
    val repository: MoviesRepository,
    val view: MoviesListContract.View?
) : MoviesListContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun subscribe() {
        val disposable = repository.getConfiguration()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::getMovies)

        compositeDisposable.add(disposable)
    }

    override fun unsubscribe() {
        compositeDisposable.clear()
    }

    override fun getMovies() {
        val observableImageUrl = repository.getImageUrl()

        val zipper = BiFunction<MostPopularMoviesResponse, String?,
                Pair<MostPopularMoviesResponse, String>> { one, two -> Pair(one, two) }

        val disposable = repository.getMostPopularMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .zipWith(observableImageUrl, zipper)
            .subscribe(this::handleSuccess, this::handleError)

        compositeDisposable.add(disposable)
    }

    override fun handleSuccess(pair: Pair<MostPopularMoviesResponse, String>) {
        val mostPopularMoviesResponse = pair.first
        val imageUrl = pair.second
        val movies = mostPopularMoviesResponse.movieResponses?.map {
            Movie(
                id = it?.id ?: -1,
                title = it?.title ?: "",
                year = it?.releaseDate ?: "",
                vote = it?.voteAverage.toString(),
                genre = it?.genreIds?.joinToString(", ") ?: "",
                actors = "",
                image = "$imageUrl${it?.posterPath}"
            )
        }

        movies?.let {
            view?.showMovies(it)
        }
    }

    override fun handleError(throwable: Throwable) {

    }
}