package com.example.shiftproj.feature.cityTemp.list.domain

import com.example.shiftproj.feature.cityTemp.domain.entity.CityTemp
import com.example.shiftproj.feature.repos.dataBase.DataBaseRepos
import com.example.shiftproj.feature.repos.dataBase.IDataStore

object GetCitesTempsUseCase {
    operator fun invoke() : IDataStore<CityTemp> = DataBaseRepos
}