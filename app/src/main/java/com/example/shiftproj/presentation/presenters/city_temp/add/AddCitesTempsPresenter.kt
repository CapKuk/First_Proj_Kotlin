package com.example.shiftproj.presentation.presenters.city_temp.add

import com.example.shiftproj.presentation.presenters.BasePresenter
import com.example.shiftproj.presentation.ui.citesTemp.add.AddCityTempActivity

class AddCitesTempsPresenter : BasePresenter<AddCityTempActivity>() {
    fun onAddButtonClick(city : String?, temp : String?){
        if(city == null || city == "" ||
            temp == null || temp == ""){
            view?.showToast()
            return
        }
        view?.onAddButtonClick(city, temp.toInt())
    }
    override fun onViewAttached() {
        super.onViewAttached()
    }
}
