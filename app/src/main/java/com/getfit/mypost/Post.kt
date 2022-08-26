package com.getfit.mypost

data class Post(
    var userId:String,
    var id:Int,
    var title:String,
    var body:String,

)
data class comment(
    var postId:Int,
    var id: Int,
    var name:String,
    var Email:String,
    var body:String,
)

