package com.example.tomaszmatusik.gitfinder.activities.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.tomaszmatusik.gitfinder.data.responses.RepositoryResponse
import com.example.tomaszmatusik.gitfinder.data.responses.UsersResponse

class MainViewModel(var mainRepository: MainRepository) : ViewModel() {
    fun getUserSearchResults(query: String?, sort: String?, order: String?)
            : LiveData<UsersResponse> = mainRepository.getUserSearchResults(query, sort, order)

    fun getRepositoriesSearchResults(query: String?, sort: String?, order: String?)
            : LiveData<RepositoryResponse> = mainRepository.getRepositoriesSearchResults(query, sort, order)
}