package com.hfad.viewmodelappkotlin.ui.main.viewmodel

import com.hfad.viewmodelappkotlin.ui.main.view.Weather

sealed class AppState{
       data class Success(val dataWeather: Weather):AppState()
       data class Error( val error:Throwable):AppState()
       object Loading: AppState()
}
