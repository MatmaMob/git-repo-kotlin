package com.example.tomaszmatusik.gitfinder.api

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.tomaszmatusik.gitfinder.data.responses.RepositoryResponse
import com.example.tomaszmatusik.gitfinder.data.responses.UserDetailResponse
import com.example.tomaszmatusik.gitfinder.data.responses.UsersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class ResponseHelper @Inject constructor(retrofit: Retrofit) {

    var service: ApiService? = retrofit.create(ApiService::class.java)
    var userData: MutableLiveData<UsersResponse> = MutableLiveData()
    var repositoryData: MutableLiveData<RepositoryResponse> = MutableLiveData()
    var userDetailsData: MutableLiveData<UserDetailResponse> = MutableLiveData()

    fun getUserSearchResults(query: String?, sort: String?, order: String?): LiveData<UsersResponse> {
        service?.filterUsers(query, sort, order)?.enqueue(object : Callback<UsersResponse> {

            override fun onResponse(call: Call<UsersResponse>?, response: Response<UsersResponse>?) {
                if (response!!.isSuccessful) {
                    userData.value = response.body()
                }
            }

            override fun onFailure(call: Call<UsersResponse>?, t: Throwable?) {
                Log.d("API", "USER RESPONSE ERROR: " + t!!.message)
            }
        })
        return userData
    }

    fun getRepositoriesSearchResults(query: String?, sort: String?, order: String?): LiveData<RepositoryResponse> {
        service?.filterRepositories(query, sort, order)?.enqueue(object : Callback<RepositoryResponse> {

            override fun onResponse(call: Call<RepositoryResponse>, response: Response<RepositoryResponse>) {
                if (response.isSuccessful) {
                    repositoryData.value = response.body()
                }
            }

            override fun onFailure(call: Call<RepositoryResponse>, t: Throwable) {
                Log.d("API", "REPOSITORY RESPONSE ERROR: " + t.message)
            }
        })
        return repositoryData
    }

    fun getUserDetail(login: String?): LiveData<UserDetailResponse> {
        service?.getUserDetails(login)?.enqueue(object : Callback<UserDetailResponse> {

            override fun onResponse(call: Call<UserDetailResponse>, response: Response<UserDetailResponse>) {
                if (response.isSuccessful) {
                    userDetailsData.value = response.body()
                }
            }

            override fun onFailure(call: Call<UserDetailResponse>, t: Throwable) {
                Log.d("API", "USER DETAILS RESPONSE ERROR: " + t.message)
            }
        })
        return userDetailsData
    }
}