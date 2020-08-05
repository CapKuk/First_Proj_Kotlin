package com.example.server.repository.dataBase

interface IDataStore<T> {
    suspend fun getAll() : List<T>?
    suspend fun add(item : T)
    suspend fun delete(id: Long)
    fun get(name : String) : T?
    fun get(id : Long) : T?
}