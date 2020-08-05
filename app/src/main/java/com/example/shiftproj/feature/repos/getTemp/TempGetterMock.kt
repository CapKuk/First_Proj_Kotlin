package com.example.shiftproj.feature.repos.getTemp

import kotlin.math.roundToInt
import kotlin.random.Random

class TempGetterMock : IGetTemp {
    override fun isRealCity(city: String): Boolean {
        return true
    }
    override fun getTemp(city : String): Long {
        return Random.nextLong(60) - 30
    }
}