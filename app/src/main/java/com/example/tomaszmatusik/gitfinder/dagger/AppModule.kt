package com.example.tomaszmatusik.gitfinder.dagger

import com.example.tomaszmatusik.gitfinder.api.ApiHelper
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AppModule(var app: DaggApp) {

    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return ApiHelper.getHelper()!!
    }
}