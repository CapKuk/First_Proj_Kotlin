package com.example.server.repository.getTemp

interface IGetTemp {
    fun isRealCity(city : String) : Boolean
    fun getTemp(city : String) : Long
}