package com.atahan.fakeapiapp.model

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("userID")
    val userId: Int,

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String?,

    @SerializedName("body")
    val body: String?
)
