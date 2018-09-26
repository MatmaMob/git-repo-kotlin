package com.example.tomaszmatusik.gitfinder.dagger

import com.example.tomaszmatusik.gitfinder.activities.details.DetailActivity
import com.example.tomaszmatusik.gitfinder.activities.main.MainActivity
import dagger.Component

@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(daggApp: DaggApp)
    fun inject(mainActivity: MainActivity)
    fun inject(detailActivity: DetailActivity)
}