package com.hfad.viewmodelappkotlin.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hfad.viewmodelappkotlin.ui.main.model.Repository
import com.hfad.viewmodelappkotlin.ui.main.model.RepositoryInml
import java.lang.Thread.sleep

class MainViewModel(
    private val liveDataToObserver: MutableLiveData<AppState> =
        MutableLiveData(),
    val repository: Repository = RepositoryInml()
) : ViewModel() {

    fun getData(): LiveData<AppState> {
        getDataFromLocalSource()
        return liveDataToObserver
    }

    fun getWeather() = getDataFromLocalSource()

    fun getDataFromLocalSource() {
        Thread {
            liveDataToObserver.postValue(AppState.Loading)
            sleep(2500)
            liveDataToObserver.postValue(AppState.Success(repository.getWeatherfromLocal()))
        }.start()
    }


}