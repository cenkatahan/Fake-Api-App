package com.atahan.fakeapiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.atahan.fakeapiapp.model.Post
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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