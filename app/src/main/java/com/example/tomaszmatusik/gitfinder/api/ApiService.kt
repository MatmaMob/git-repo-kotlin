package com.example.tomaszmatusik.gitfinder.api

import com.example.tomaszmatusik.gitfinder.data.responses.RepositoryResponse
import com.example.tomaszmatusik.gitfinder.data.responses.UserDetailResponse
import com.example.tomaszmatusik.gitfinder.data.responses.UsersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("/search/users")
    fun filterUsers(@Query("q") q: String?, @Query("sort") sort: String?, @Query("order") order: String?)
            : Call<UsersResponse>

    @GET("/search/repositories")
    fun filterRepositories(@Query("q") q: String?, @Query("sort") sort: String?, @Query("order") order: String?)
            : Call<RepositoryResponse>

    @GET("users/{login}")
    fun getUserDetails(@Path("login") login: String?): Call<UserDetailResponse>
}