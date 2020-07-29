package com.example.shiftproj.feature.cityTemp.add.domain

import com.example.shiftproj.feature.repos.getTemp.IGetTemp
import com.example.shiftproj.feature.repos.getTemp.TempRepos

object GetTempUseCase {
    operator fun invoke() : IGetTemp = TempRepos
}