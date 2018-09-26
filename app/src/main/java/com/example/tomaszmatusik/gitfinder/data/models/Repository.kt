package com.example.tomaszmatusik.gitfinder.data.models

import com.google.gson.annotations.SerializedName

class Repository : Comparable<Repository> {

    @SerializedName("id")
    var id: Int = 0
    @SerializedName("node_id")
    var node_id: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("full_name")
    var full_name: String? = null
    @SerializedName("private")
    var private: Boolean? = null
    @SerializedName("owner")
    var owner: Owner? = null

    override fun compareTo(other: Repository): Int {

        val compareId: Int = other.id
        return compareId - id
    }
}