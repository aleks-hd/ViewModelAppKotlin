package com.hfad.viewmodelappkotlin.ui.main.model

import com.hfad.viewmodelappkotlin.ui.main.view.Weather

interface Repository {
    fun getWeatherfromServer(): Weather
    fun getWeatherfromLocal(): Weather
}