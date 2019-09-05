package com.carlosandrade.moviebus.repository.local

import android.content.SharedPreferences
import com.carlosandrade.moviebus.repository.remote.response.ConfigurationResponse
import com.carlosandrade.util.Constants


class LocalDataSourceImpl(private val pref: SharedPreferences) : LocalDataSource {

    override fun saveUrlImage(config: ConfigurationResponse) {
        val baseUrl = config.images?.baseUrl
        val size = config.images?.posterSizes?.get(5)

        pref.edit().putString(Constants.IMAGE_URL, "$baseUrl/$size").apply()
    }

    override fun getUrlImage(): String? = pref.getString(Constants.IMAGE_URL, "")
}