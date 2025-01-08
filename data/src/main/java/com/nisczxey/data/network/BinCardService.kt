package com.nisczxey.data.network

import com.nisczxey.data.network.model.CardCloudModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface BinCardService {

    @GET("/{bin}")
    suspend fun getCard(@Path("bin") bin: String): CardCloudModel

    companion object {
        val BASE_URL = "https://lookup.binlist.net"

        fun create(): BinCardService {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(BinCardService::class.java)
        }
    }
}