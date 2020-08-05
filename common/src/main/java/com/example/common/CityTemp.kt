package com.example.common

import java.io.Serializable

data class CityTemp (val city : String, val temp : Long = -1, val id : Long = -1) : Serializable
