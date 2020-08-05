package com.example.server.db.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object CitiesTemps : Table() {
    val id: Column<Long> = CitiesTemps.long("id").autoIncrement().primaryKey()
    val city: Column<String> = CitiesTemps.text("city")
    val temp: Column<Double> = CitiesTemps.double("temp")
}