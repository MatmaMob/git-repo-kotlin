package com.example.tomaszmatusik.gitfinder.data.responses

import com.example.tomaszmatusik.gitfinder.data.models.User
import com.google.gson.annotations.SerializedName

class UsersResponse {
    @SerializedName("total_count")
    var total_count: Int? = 0
    @SerializedName("incomplete_results")
    var incomplete_results: Boolean? = false
    @SerializedName("items")
    lateinit var items: MutableList<User>
}