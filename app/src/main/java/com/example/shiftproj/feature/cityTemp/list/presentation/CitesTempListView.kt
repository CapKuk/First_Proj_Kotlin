package com.example.shiftproj.feature.cityTemp.list.presentation

import com.example.shiftproj.feature.cityTemp.domain.entity.CityTemp
import com.example.shiftproj.feature.util.ViewContract

interface CitesTempListView : ViewContract {

    fun setCitesTempsList(cites_temps: List<CityTemp>?)

    fun showCitesTempsDetails(cites_temps: CityTemp)

    fun showAddItemActivity()
}