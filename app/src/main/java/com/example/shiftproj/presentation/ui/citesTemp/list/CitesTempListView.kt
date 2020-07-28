package com.example.shiftproj.presentation.ui.citesTemp.list

import com.example.shiftproj.model.entity.CityTemp
import com.example.shiftproj.presentation.ui.ViewContract

interface CitesTempListView : ViewContract {

    fun setCitesTempsList(cites_temps: List<CityTemp>?)

    fun showCitesTempsDetails(cites_temps: CityTemp)

    fun showAddItemActivity()
}