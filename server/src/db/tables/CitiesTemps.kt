package com.example.server.db.tables

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object CitiesTemps : Table() {
    val id: Column<Long> = long("id").autoIncrement().primaryKey()
    val city: Column<String> = text("city")
    val temp: Column<Float> = float("temp")
}