package com.example.tomaszmatusik.gitfinder.data.models

import com.google.gson.annotations.SerializedName

class Owner {
    @SerializedName("login")
    private var login: String? = null
    @SerializedName("id")
    private var id: Int = 0
    @SerializedName("node_id")
    private var node_id: String? = null
    @SerializedName("avatar_url")
    private var avatar_url: String? = null
    @SerializedName("gravatar_id")
    private var gravatar_id: String? = null
    @SerializedName("url")
    private var url: String? = null
    @SerializedName("html_url")
    private var html_url: String? = null
    @SerializedName("followers_url")
    private var followers_url: String? = null
    @SerializedName("following_url")
    private var following_url: String? = null
    @SerializedName("gists_url")
    private var gists_url: String? = null
    @SerializedName("starred_url")
    private var starred_url: String? = null
    @SerializedName("subscriptions_url")
    private var subscriptions_url: String? = null
    @SerializedName("organizations_url")
    private var organizations_url: String? = null
    @SerializedName("repos_url")
    private var repos_url: String? = null
    @SerializedName("events_url")
    private var events_url: String? = null
    @SerializedName("received_events_url")
    private var received_events_url: String? = null
    @SerializedName("type")
    private var type: String? = null
    @SerializedName("site_admin")
    private var site_admin: Boolean? = null
}
