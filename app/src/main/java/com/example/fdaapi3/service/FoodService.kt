package com.example.fdaapi3.service

import com.example.fdaapi3.models.RecalledItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface FoodService {
    @GET("food/enforcement.json")
    fun getRecalledItem(@Query("search") s: String, @Query ("limit") l : Int) : Call<RecalledItem>
}