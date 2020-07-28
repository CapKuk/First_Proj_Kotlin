package com.example.shiftproj.presentation.presenters.city_temp.list

import com.example.shiftproj.model.entity.CityTemp
import com.example.shiftproj.presentation.presenters.BasePresenter
import com.example.shiftproj.presentation.ui.citesTemp.list.CitesTempListView

class CitesTempsListPresenter : BasePresenter<CitesTempListView>() {

    private val citesTemps = arrayListOf(
        CityTemp("Новосибирск", 30),
        CityTemp("Питер", 18),
        CityTemp("Москва", 18),
        CityTemp("Бердск", 29),
        CityTemp("Самара", 25)
    )

    override fun onViewAttached() {
        view?.setCitesTempsList(citesTemps)
    }

    fun onCityTempClick(cityTemp: CityTemp) {
        view?.showCitesTempsDetails(cityTemp)
    }

    fun onAddButtonClick(){
        view?.showAddItemActivity()
    }
}