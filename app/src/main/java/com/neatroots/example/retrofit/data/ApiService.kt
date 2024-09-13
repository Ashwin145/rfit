package com.neatroots.example.retrofit.data

import com.neatroots.example.retrofit.data.Model.Products
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getPrducts():Products

    companion object{
        const val BASE_URL = "https://dummyjson.com/products"
    }
}