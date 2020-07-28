package com.example.shiftproj.model.dataBase

import com.example.shiftproj.model.entity.CityTemp

class MockDataStore : IDataStore<CityTemp> {

    private var citesTemps = arrayListOf(
        CityTemp("Новосибирск", 30, 1),
        CityTemp("Питер", 18, 2),
        CityTemp("Москва", 18, 3),
        CityTemp("Бердск", 29, 4),
        CityTemp("Самара", 25, 5))

    override fun getAll() : List<CityTemp>? {
        return citesTemps
    }

    override fun get(id: Int): CityTemp? {
        var lookedItem : CityTemp? = null
        citesTemps.forEach { if(it.id == id){
            lookedItem = it
        } }
        return lookedItem
    }

    override fun get(name: String): CityTemp? {
        var lookedItem : CityTemp? = null
        citesTemps.forEach { if(it.city == name){
            lookedItem = it
        } }
        return lookedItem
    }

    override fun add(item: CityTemp) {
        citesTemps.add(item)
    }
}