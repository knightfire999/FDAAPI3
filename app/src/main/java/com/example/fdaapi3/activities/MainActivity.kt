package com.example.fdaapi3.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fdaapi3.R
import com.example.fdaapi3.helpers.ItemAdapter
import com.example.fdaapi3.models.Item
import com.example.fdaapi3.models.RecalledItem
import com.example.fdaapi3.service.FoodService
import com.example.fdaapi3.service.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity() {
    val TAG = "LookHere"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadItems()
    }

    private fun loadItems() {
        //initiate the service
        val destinationService = ServiceBuilder.buildService(FoodService::class.java)
        val requestCall = destinationService.getRecalledItem("classification:Class+III", 10)
        //make network call asynchronously
        requestCall.enqueue(object : Callback<RecalledItem> {
            override fun onResponse(call: Call<RecalledItem>, response: Response<RecalledItem>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful) {
                    val results = response.body()?.results?:emptyList<Item>()
                    Log.d("Response", "RecalledItem size : ${results.size}")
                    item_recycler.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@MainActivity, 4)
                        adapter = ItemAdapter(results)
                    }
                } else {
                    Log.d(TAG, response.headers().toString())
                }
            }
            override fun onFailure(call: Call<RecalledItem>, t: Throwable) {
                Log.d(TAG, t.message.toString())
            }
        })
    }
}