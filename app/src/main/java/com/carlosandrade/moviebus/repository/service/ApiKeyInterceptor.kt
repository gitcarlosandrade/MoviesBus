package com.carlosandrade.moviebus.repository.service

import okhttp3.Interceptor
import okhttp3.Response

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val url = chain
            .request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()
        val newRequest = chain
            .request()
            .newBuilder()
            .url(url)
            .build()
        return chain.proceed(newRequest)
    }
}