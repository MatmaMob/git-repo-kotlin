package com.example.tomaszmatusik.gitfinder.activities.details

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.tomaszmatusik.gitfinder.data.responses.UserDetailResponse

class DetailViewModel(var detailRepository: DetailRepository) : ViewModel() {

    fun getUserDetails(login: String?)
            : LiveData<UserDetailResponse> = detailRepository.getUserDetails(login)
}