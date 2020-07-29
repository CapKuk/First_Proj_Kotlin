package com.example.shiftproj.feature.cityTemp.list.presentation

import com.example.shiftproj.feature.cityTemp.domain.entity.CityTemp
import com.example.shiftproj.feature.cityTemp.list.domain.GetCitesTempsUseCase
import com.example.shiftproj.feature.util.BasePresenter

class CitesTempsListPresenter : BasePresenter<CitesTempListView>() {
    override fun onViewAttached() {
        view?.setCitesTempsList(GetCitesTempsUseCase().getAll())
    }

    fun onCityTempClick(cityTemp: CityTemp) {
        view?.showCitesTempsDetails(cityTemp)
    }

    fun onAddButtonClick(){
        view?.showAddItemActivity()
    }
}