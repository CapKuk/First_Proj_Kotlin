package com.example.common

import java.io.Serializable

data class CityTemp (val city : String, val temp : Float = -1.0F, val id : Long = -1) : Serializable
