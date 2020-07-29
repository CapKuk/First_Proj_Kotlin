package com.example.shiftproj.feature.repos.getTemp

import kotlin.math.roundToInt
import kotlin.random.Random

class TempGetterMock : IGetTemp {
    override fun isRealCity(city: String): Boolean {
        return true
    }
    override fun getTemp(city : String): Double {
        return Random.nextInt(60) - 30 + ((Random.nextDouble() * 100.0).roundToInt() / 100.0)
    }
}