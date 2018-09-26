package com.example.tomaszmatusik.gitfinder.data.responses

import com.example.tomaszmatusik.gitfinder.data.models.Repository
import com.google.gson.annotations.SerializedName

class RepositoryResponse {

    @SerializedName("total_count")
    var total_count: Int? = 0
    @SerializedName("incomplete_results")
    var incomplete_results: Boolean? = false
    @SerializedName("items")
    lateinit var items: MutableList<Repository>
}