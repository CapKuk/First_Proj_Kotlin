package com.example.shiftproj.feature.repos.dataBase

interface IDataStore<T> {
    fun getAll() : List<T>?
    fun get(name : String) : T?
    fun get(id : Int) : T?

    fun add(item : T)
}