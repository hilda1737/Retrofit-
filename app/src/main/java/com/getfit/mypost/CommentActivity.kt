package com.getfit.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.getfit.mypost.databinding.ActivityCommentBinding
import com.getfit.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.jvm.internal.MagicApiIntrinsics

class CommentActivity : AppCompatActivity() {
    lateinit var  binding:ActivityCommentBinding
    var postId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchpostByid()
    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0

    }
    fun fetchpostByid(){
        var apiClient=ApiClient.buildApiClient(Interface::class.java)
        var request=apiClient.getpostById(postId)

        request.enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {

                    var post=response.body()
                if (post!=null){
                    binding.tvTextBody.text=post.title
                    binding.tvText.text=post.body
                }
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
//               Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

            }
        })
    }
}


