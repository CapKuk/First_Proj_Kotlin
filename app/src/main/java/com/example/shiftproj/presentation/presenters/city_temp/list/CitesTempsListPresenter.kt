package com.example.shiftproj.presentation.presenters.city_temp.list

import com.example.shiftproj.model.dataBase.IDataStore
import com.example.shiftproj.model.dataBase.MockDataStore
import com.example.shiftproj.model.entity.CityTemp
import com.example.shiftproj.presentation.presenters.BasePresenter
import com.example.shiftproj.presentation.ui.citesTemp.list.CitesTempListView

class CitesTempsListPresenter : BasePresenter<CitesTempListView>() {
    private val dataBase : IDataStore<CityTemp> = MockDataStore()
    override fun onViewAttached() {
        view?.setCitesTempsList(dataBase.getAll())
    }

    fun onCityTempClick(cityTemp: CityTemp) {
        view?.showCitesTempsDetails(cityTemp)
    }

    fun onAddButtonClick(){
        view?.showAddItemActivity()
    }
}