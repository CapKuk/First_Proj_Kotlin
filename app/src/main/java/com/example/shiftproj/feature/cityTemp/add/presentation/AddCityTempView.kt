package com.example.shiftproj.feature.cityTemp.add.presentation

import com.example.shiftproj.feature.util.ViewContract

interface AddCityTempView : ViewContract {
    fun onAddButtonClick(city : String, temp : Double)
}