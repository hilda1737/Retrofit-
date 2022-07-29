package com.getfit.mypost

data class Post(
    var userId:String,
    var Id:String,
    var title:String,
    var body:String,

)
data class comment(
    var postId:Int,
    var Id: Int,
    var name:String,
    var Email:String,
    var body:String,
)

