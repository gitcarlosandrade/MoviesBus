package com.carlosandrade.moviebus.repository.local

import com.carlosandrade.moviebus.repository.remote.response.ConfigurationResponse

interface LocalDataSource {

    fun saveUrlImage(config: ConfigurationResponse)
    fun getUrlImage(): String?
}