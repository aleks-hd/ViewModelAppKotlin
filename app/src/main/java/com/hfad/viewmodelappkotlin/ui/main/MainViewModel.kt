package com.hfad.viewmodelappkotlin.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.Thread.sleep

class MainViewModel(private val liveDataToObserver: MutableLiveData<Any> =
    MutableLiveData()) : ViewModel() {

        fun getData(): LiveData<Any>{
            getDataFromLocalSource()
            return liveDataToObserver
        }

    fun getDataFromLocalSource() {
        Thread{
            sleep(1000)
            liveDataToObserver.postValue(Any())
        }.start()
    }


}