package com.example.tomaszmatusik.gitfinder.activities.details

import android.arch.lifecycle.LiveData
import com.example.tomaszmatusik.gitfinder.api.ResponseHelper
import com.example.tomaszmatusik.gitfinder.data.responses.UserDetailResponse
import javax.inject.Inject

class DetailRepository @Inject constructor(var responseHelper: ResponseHelper) {

    fun getUserDetails(login: String?)
            : LiveData<UserDetailResponse> = responseHelper.getUserDetail(login)
}