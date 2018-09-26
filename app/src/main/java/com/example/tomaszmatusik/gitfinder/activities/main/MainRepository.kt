package com.example.tomaszmatusik.gitfinder.activities.main

import android.arch.lifecycle.LiveData
import com.example.tomaszmatusik.gitfinder.api.ResponseHelper
import com.example.tomaszmatusik.gitfinder.data.responses.RepositoryResponse
import com.example.tomaszmatusik.gitfinder.data.responses.UsersResponse
import javax.inject.Inject

class MainRepository @Inject constructor(var responseHelper: ResponseHelper) {

    fun getUserSearchResults(query: String?, sort: String?, order: String?)
            : LiveData<UsersResponse> = responseHelper.getUserSearchResults(query, sort, order)

    fun getRepositoriesSearchResults(query: String?, sort: String?, order: String?)
            : LiveData<RepositoryResponse> = responseHelper.getRepositoriesSearchResults(query, sort, order)
}