package com.example.retrofitexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.model.MarsDataBase
import com.example.retrofitexample.model.Repository
import com.example.retrofitexample.model.Terrain

class MarsViewModel(application: Application) : AndroidViewModel(application) {

    //una variable referencia al repositorio
    private val repository : Repository

        init {
            val terrainDao = MarsDataBase.getDatabase(application).getTerrainDao()
            repository = Repository(terrainDao)

            repository.getDataFromServer()
        }
    fun exposeLiveDataFromDatabase(): LiveData<List<Terrain>>{
        return  repository.mLiveData
    }
}