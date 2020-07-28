package com.example.shiftproj.model.getTemp

interface IGetTemp {
    fun isRealCity(city : String) : Boolean
    fun getTemp(city : String) : Double
}