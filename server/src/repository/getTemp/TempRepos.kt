package com.example.server.repository.getTemp

object TempRepos : IGetTemp {
    private val dataStore : IGetTemp = TempGetterMock()
    override fun getTemp(city: String): Long = dataStore.getTemp(city)
    override fun isRealCity(city: String): Boolean = dataStore.isRealCity(city)
}