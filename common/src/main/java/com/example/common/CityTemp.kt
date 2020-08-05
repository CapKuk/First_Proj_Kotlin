package com.example.common

import java.io.Serializable

data class CityTemp (val city : String, val temp : Double = -1.0, val id : Long = -1) : Serializable
