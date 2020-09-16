package com.example.retrofitexample.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    private val service = RetrofitClient.getRetrofitClient()
    val mLiveData : MutableLiveData<List<Terrain>> = MutableLiveData()

    fun getDataFromServer(){
        val call = service.getDAtaFromApi()
        call.enqueue(object : Callback<List<Terrain>> {

            override fun onResponse(call: Call<List<Terrain>>, response: Response<List<Terrain>>) {
                when(response.code()){
                    in 200..299 -> mLiveData.postValue(response.body())
                    in 300..3990 -> Log.d("ERROR 300", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<Terrain>>, t: Throwable) {
               Log.e("Repository", t.message.toString())
            }
        })
    }

}