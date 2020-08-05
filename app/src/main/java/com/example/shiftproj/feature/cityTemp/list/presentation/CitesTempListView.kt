package com.example.shiftproj.feature.cityTemp.list.presentation

import com.example.shiftproj.feature.util.ViewContract
import com.example.common.CityTemp

interface CitesTempListView : ViewContract {

    fun setCitesTempsList(cites_temps: List<CityTemp>?)

    fun showCitesTempsDetails(cites_temps: CityTemp)

    fun showAddItemActivity()
}