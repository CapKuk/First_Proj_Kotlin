package com.example.shiftproj.presentation.ui.citesTemp.add

import com.example.shiftproj.presentation.ui.ViewContract

interface AddCityTempView : ViewContract {
    fun onAddButtonClick(city : String, temp : Int)
}