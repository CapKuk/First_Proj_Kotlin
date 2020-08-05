package com.example.shiftproj.feature.cityTemp.list.domain

import com.example.shiftproj.feature.repos.dataBase.DataBaseRepos
import com.example.shiftproj.feature.repos.dataBase.IDataStore
import com.example.common.CityTemp

object GetCitesTempsUseCase {
    operator fun invoke() : IDataStore<CityTemp> = DataBaseRepos
}