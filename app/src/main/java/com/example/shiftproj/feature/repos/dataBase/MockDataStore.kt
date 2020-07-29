package com.example.shiftproj.feature.repos.dataBase

import com.example.shiftproj.feature.cityTemp.domain.entity.CityTemp

class MockDataStore : IDataStore<CityTemp> {

    private var citesTemps = arrayListOf(
        CityTemp("Новосибирск", 30.0, 1),
        CityTemp("Питер", 18.0, 2),
        CityTemp("Москва", 18.0, 3),
        CityTemp("Бердск", 29.0, 4),
        CityTemp("Самара", 25.0, 5))

    override fun getAll() : List<CityTemp>? {
        return citesTemps
    }

    override fun get(id: Int): CityTemp? {
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

    override fun add(item: CityTemp) {
        citesTemps.add(item)
    }
}