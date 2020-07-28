package com.example.shiftproj.model.entity

import java.io.Serializable

data class CityTemp (val city : String, val temp : Double = -1.0, val id : Int = -1) : Serializable
