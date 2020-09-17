package com.example.retrofitexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitexample.model.Repository
import com.example.retrofitexample.model.Terrain

class MarsViewModel : ViewModel() {
    //una variable referencia al repositorio
    private val repository = Repository()

        init {
            //indico el metodo que traera el val repositorio
            repository.getDataFromServer()
        }
    fun exposeLiveDAtaFromServer(): LiveData<List<Terrain>>{
        return  repository.mLiveData
    }
}