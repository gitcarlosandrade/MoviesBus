package com.carlosandrade.moviebus.repository.remote.response
import com.google.gson.annotations.SerializedName


data class ConfigurationResponse(
    @SerializedName("change_keys") val changeKeys: List<String?>? = null,
    val images: ImagesResponse? = null
)