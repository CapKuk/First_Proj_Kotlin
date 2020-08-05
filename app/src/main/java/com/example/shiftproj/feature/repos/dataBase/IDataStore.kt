package com.example.shiftproj.feature.repos.dataBase

interface IDataStore<T> {
    suspend fun getAll() : List<T>?
    suspend fun add(item : T)
    suspend fun delete(id: Long)
    fun get(name : String) : T?
    fun get(id : Long) : T?
}