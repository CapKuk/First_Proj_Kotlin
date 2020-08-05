package com.example.shiftproj.feature.repos.dataBase

import com.example.common.CityTemp

class MockDataStore : IDataStore<CityTemp> {
    override suspend fun delete(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var citesTemps = arrayListOf(
        CityTemp("Новосибирск", 30.0, 1),
        CityTemp("Питер", 18.0, 2),
        CityTemp("Москва", 18.0, 3),
        CityTemp("Бердск", 29.0, 4),
        CityTemp("Самара", 25.0, 5)
    )

    override suspend fun getAll() : List<CityTemp>? {
        return citesTemps
    }

    override fun get(id: Long): CityTemp? {
        citesTemps.forEach { if(it.id == id){
            return it
        } }
        return null
    }

    override fun get(name: String): CityTemp? {
        citesTemps.forEach { if(it.city == name){
            return it
        } }
        return null
    }

    override suspend fun add(item: CityTemp) {
        citesTemps.add(item)
    }
}