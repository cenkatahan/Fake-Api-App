package com.atahan.fakeapiapp

import com.atahan.fakeapiapp.model.Post
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getPosts(): Call<List<Post>>
}