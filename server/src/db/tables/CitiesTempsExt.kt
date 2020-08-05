package com.example.server.db.tables

import com.example.common.CityTemp
import org.jetbrains.exposed.sql.ResultRow

fun ResultRow.toCityTemp() = CityTemp(
    id = this[CitiesTemps.id],
    city = this[CitiesTemps.city],
    temp = this[CitiesTemps.temp]
)