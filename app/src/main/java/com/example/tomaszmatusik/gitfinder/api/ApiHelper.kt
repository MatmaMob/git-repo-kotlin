package com.example.tomaszmatusik.gitfinder.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiHelper {
    companion object {
        val BASE_URL = "https://api.github.com/"
        var retrofit: Retrofit? = null

        fun getHelper(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(getOkHttpClient())
                        .build()
            }
            return retrofit
        }

        fun getOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES)
                .build()
    }
}