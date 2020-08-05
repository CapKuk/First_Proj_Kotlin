package com.example.shiftproj.feature.repos.dataBase

import com.example.common.CityTemp
import com.example.shiftproj.feature.cityTemp.list.domain.CitiesTempAPI
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DataStore : IDataStore<CityTemp> {
    private var api : CitiesTempAPI? = null

    init {
        val baseUrl : String = ""
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        api = retrofit.create(CitiesTempAPI::class.java)
    }

    override suspend fun getAll(): List<CityTemp>? {
        return api?.getAll()
    }

    override suspend fun add(item: CityTemp) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun delete(id: Long) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(name: String): CityTemp? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: Long): CityTemp? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}