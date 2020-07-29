package com.example.shiftproj.feature.cityTemp.add.presentation

import com.example.shiftproj.feature.cityTemp.add.domain.GetTempUseCase
import com.example.shiftproj.feature.util.BasePresenter

class AddCitesTempsPresenter : BasePresenter<AddCityTempActivity>() {
    fun onAddButtonClick(city : String?){
        if(city == null || city == ""){
            view?.showToast("Введены неверные данные. Одна из строк оказалась пуста.")
            return
        }
        if(!GetTempUseCase().isRealCity(city)){
            view?.showToast("Введенного города не существует в базе данных")
            return
        }
        view?.onAddButtonClick(city, GetTempUseCase().getTemp(city))
    }
}
