package com.example.shiftproj.feature.repos.getTemp

object TempRepos : IGetTemp {
    private val dataStore : IGetTemp = TempGetterMock()
    override fun getTemp(city: String): Double = dataStore.getTemp(city)
    override fun isRealCity(city: String): Boolean = dataStore.isRealCity(city)
}