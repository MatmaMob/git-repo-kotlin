package com.example.tomaszmatusik.gitfinder.dagger

import android.app.Application

class DaggApp : Application() {
    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        appComponent!!.inject(this)
    }

    fun getAppComponent(): AppComponent? = appComponent
}