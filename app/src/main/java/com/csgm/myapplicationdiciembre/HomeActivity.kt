package com.csgm.myapplicationdiciembre

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var ufAdapter: UfAdapter
    private lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        ufAdapter = UfAdapter()
        recyclerView.adapter = ufAdapter

/*        val retrofit = Retrofit.Builder()
            .baseUrl("https://mindicador.cl/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)*/

        val apiService = ApiClient.apiService
        val call = apiService.getUF()

        call.enqueue(object : Callback<UFResponse> {
            override fun onResponse(call: Call<UFResponse>, response: Response<UFResponse>) {
                if (response.isSuccessful) {
                    val ufDataList = response.body()?.serie
                    ufDataList?.let {
                        ufAdapter.setData(it)
                    }
                }
            }

            override fun onFailure(call: Call<UFResponse>, t: Throwable) {
                t.printStackTrace()
            }
        })

        btnLogout = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            logoutUser()
        }
    }

    private fun logoutUser() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}
