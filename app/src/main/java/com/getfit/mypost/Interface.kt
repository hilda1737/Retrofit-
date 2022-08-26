package com.getfit.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Interface {
    @GET("/posts")
    fun getPosts(): retrofit2.Call<List<Post>>
    @GET("/posts/{postId}")
    fun getpostById(@Path("postId")postId:Int) : Call<Post>
}
