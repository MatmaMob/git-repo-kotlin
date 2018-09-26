package com.example.tomaszmatusik.gitfinder.factories

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.tomaszmatusik.gitfinder.activities.details.DetailRepository
import com.example.tomaszmatusik.gitfinder.activities.details.DetailViewModel
import com.example.tomaszmatusik.gitfinder.activities.main.MainRepository
import com.example.tomaszmatusik.gitfinder.activities.main.MainViewModel
import javax.inject.Inject

class ViewModelFactory @Inject constructor(var mainRepository: MainRepository, var detailRepository: DetailRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(mainRepository) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(detailRepository) as T
        } else {
            run { throw IllegalArgumentException("View model not found") }
        }
    }
}