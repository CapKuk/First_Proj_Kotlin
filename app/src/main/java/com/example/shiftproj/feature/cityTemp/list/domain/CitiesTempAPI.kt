package com.example.shiftproj.feature.cityTemp.list.domain

import com.example.common.CityTemp
import retrofit2.http.GET

interface CitiesTempAPI {
    @GET("/temps")
    suspend fun getAll(): List<CityTemp>
}