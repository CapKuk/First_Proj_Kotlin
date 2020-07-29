package com.example.shiftproj.feature.repos.dataBase

import com.example.shiftproj.feature.cityTemp.domain.entity.CityTemp

object DataBaseRepos : IDataStore<CityTemp> {
    private val dataStore : IDataStore<CityTemp> = MockDataStore()

    override fun getAll(): List<CityTemp>? = dataStore.getAll()
    override fun get(name: String): CityTemp? = dataStore.get(name)
    override fun get(id: Int): CityTemp? = dataStore.get(id)
    override fun add(item: CityTemp) = dataStore.add(item)
}