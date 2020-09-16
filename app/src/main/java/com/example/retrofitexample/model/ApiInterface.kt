package com.example.retrofitexample.model

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("realestate")
    fun getDAtaFromApi() : Call<List<Terrain>>



}