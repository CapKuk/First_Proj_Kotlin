package com.example.server.repository.dataBase

import com.example.common.CityTemp
import repository.dataBase.CitiesTempRepository

object DataBaseRepos : IDataStore<CityTemp> {

    private val dataStore : IDataStore<CityTemp> = CitiesTempRepository()

    override suspend fun getAll(): List<CityTemp>? = dataStore.getAll()
    override fun get(name: String): CityTemp? = dataStore.get(name)
    override fun get(id: Long): CityTemp? = dataStore.get(id)
    override suspend fun add(item: CityTemp) = dataStore.add(item)
    override suspend fun delete(id: Long) = dataStore.delete(id)
}