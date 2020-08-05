package com.example.shiftproj.feature.repos.getTemp

interface IGetTemp {
    fun isRealCity(city : String) : Boolean
    fun getTemp(city : String) : Long
}