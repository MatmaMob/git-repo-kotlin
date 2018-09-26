package com.example.tomaszmatusik.gitfinder.data.models

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User : Comparable<User>, Serializable {

    @SerializedName("login")
    var login: String? = null
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("avatar_url")
    var avatar_url: String? = ""
    @SerializedName("gravatar_url")
    var gravatar_url: String? = ""
    @SerializedName("url")
    var url: String? = ""
    @SerializedName("html_url")
    var html_url: String? = ""
    @SerializedName("followers_url")
    var followers_url: String? = ""
    @SerializedName("following_url")
    var following_url: String? = ""
    @SerializedName("gists_url")
    var gists_url: String? = ""
    @SerializedName("starred_url")
    var starred_url: String? = ""
    @SerializedName("subscriptions_url")
    var subscriptions_url: String? = ""
    @SerializedName("organizations_url")
    var organizations_url: String? = ""
    @SerializedName("repos_url")
    var repos_url: String? = ""
    @SerializedName("event_url")
    var event_url: String? = ""
    @SerializedName("received_events_url")
    var received_events_url: String? = ""
    @SerializedName("type")
    var type: String? = ""
    @SerializedName("site_admin")
    var site_admin: Boolean? = false
    @SerializedName("score")
    var score: Double? = 0.0

    override fun compareTo(other: User): Int {
        val compareId: Int = other.id
        return compareId - id
    }
}