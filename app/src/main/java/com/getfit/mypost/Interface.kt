package com.getfit.mypost

import retrofit2.http.GET

interface Interface {
    @GET("/posts")
    fun getPosts(): retrofit2.Call<List<Post>>
}
