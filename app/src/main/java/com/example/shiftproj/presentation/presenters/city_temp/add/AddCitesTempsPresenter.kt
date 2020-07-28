package com.example.shiftproj.presentation.presenters.city_temp.add

import com.example.shiftproj.model.getTemp.IGetTemp
import com.example.shiftproj.model.getTemp.TempGetterMock
import com.example.shiftproj.presentation.presenters.BasePresenter
import com.example.shiftproj.presentation.ui.citesTemp.add.AddCityTempActivity

class AddCitesTempsPresenter : BasePresenter<AddCityTempActivity>() {
    private val tempGetter : IGetTemp = TempGetterMock()
    fun onAddButtonClick(city : String?){
        if(city == null || city == ""){
            view?.showToast("Введены неверные данные. Одна из строк оказалась пуста.")
            return
        }
        if(!tempGetter.isRealCity(city)){
            view?.showToast("Введенного города не существует в базе данных")
            return
        }
        view?.onAddButtonClick(city, tempGetter.getTemp(city))
    }
}
