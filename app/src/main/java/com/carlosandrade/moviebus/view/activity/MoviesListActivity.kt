package com.carlosandrade.moviebus.view.activity

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.carlosandrade.moviebus.R
import com.carlosandrade.moviebus.presenter.model.Movie
import com.carlosandrade.moviebus.presenter.movies.MoviesListContract
import com.carlosandrade.moviebus.presenter.movies.MoviesListPresenterImpl
import com.carlosandrade.moviebus.repository.MoviesRepositoryImpl
import com.carlosandrade.moviebus.repository.local.LocalDataSourceImpl
import com.carlosandrade.moviebus.repository.remote.RemoteDataSourceImpl
import com.carlosandrade.moviebus.repository.service.ApiGenerator
import com.carlosandrade.moviebus.view.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MoviesListActivity : AppCompatActivity(), MoviesListContract.View {

    lateinit var presenter: MoviesListContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val local = LocalDataSourceImpl(
            pref = this.getSharedPreferences(
                "moviePref",
                Context.MODE_PRIVATE
            )
        )
        val remote = RemoteDataSourceImpl(api = ApiGenerator.getApi())
        val moviesRepo = MoviesRepositoryImpl(remote = remote, local = local)
        presenter = MoviesListPresenterImpl(repository = moviesRepo, view = this)

        presenter.subscribe()

        moviesRV.setHasFixedSize(true)
        moviesRV.layoutManager = LinearLayoutManager(this)
    }

    override fun showMovies(movies: List<Movie>) {
        moviesRV.adapter = MoviesAdapter(movies) { id ->
            Toast.makeText(this, id.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun hideLoader() {

    }

    override fun showLoader() {

    }

    override fun hideMovies() {

    }
}
