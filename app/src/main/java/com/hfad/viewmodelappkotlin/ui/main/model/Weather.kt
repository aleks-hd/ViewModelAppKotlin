package com.hfad.viewmodelappkotlin.ui.main.view

class Weather (val city:City = getDefaultCity(), val temperature:Int = 22, val feelalike:Int = 24)

fun getDefaultCity() = City("Мосвка", 55.75, 37.61 )

data class City(val city:String,val lat:Double,val long:Double)
