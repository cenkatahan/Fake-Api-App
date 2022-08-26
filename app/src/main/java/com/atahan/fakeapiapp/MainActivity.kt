package com.atahan.fakeapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atahan.fakeapiapp.model.Post
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var posts: ArrayList<Post>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view_post)
        posts = ArrayList()
        val adapter = PostAdapter(posts)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(Api::class.java)
        val call = api.getPosts()

        call.enqueue(object : Callback<List<Post>>{
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (!response.isSuccessful){
                    Log.d(TAG, response.message())
                    //TODO unsuccessful scenario
                }
                //TODO successful scenario
                Log.d(TAG, "${response.body()}")
                response.body()?.let { posts.addAll(it) }
                adapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com"
        private const val TAG = "API"

    }
}