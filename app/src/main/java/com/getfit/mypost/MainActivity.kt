package com.getfit.mypost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.getfit.mypost.ApiClient.retrofit
import com.getfit.mypost.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        FetchPosts()
    }

    fun FetchPosts() {
        val apiClient = ApiClient.buildApiClient(Interface::class.java)
        val request = apiClient.getPosts()
        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    var post = response.body()
                    Toast.makeText(baseContext, "Fetched ${post!!.size} post", Toast.LENGTH_LONG)
                        .show()

                    var commentAdapter=Retrofitdapter(baseContext,post)
                    binding.rvComments.layoutManager=LinearLayoutManager(baseContext)
                    binding.rvComments.adapter=commentAdapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

        })
    }
}








