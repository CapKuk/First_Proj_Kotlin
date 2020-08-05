package com.example.shiftproj.feature.cityTemp.list.presentation

import com.example.common.CityTemp
import com.example.shiftproj.feature.cityTemp.list.domain.CitiesTempAPI
import com.example.shiftproj.feature.cityTemp.list.domain.GetCitesTempsUseCase
import com.example.shiftproj.feature.util.BasePresenter
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CitesTempsListPresenter : BasePresenter<CitesTempListView>() {
    override suspend fun onViewAttached() {
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

        val api = retrofit.create(CitiesTempAPI::class.java)

        view?.setCitesTempsList(GetCitesTempsUseCase().getAll())

        view?.setCitesTempsList(api.getAll())
    }

    fun onCityTempClick(cityTemp: CityTemp) {
        view?.showCitesTempsDetails(cityTemp)
    }

    fun onAddButtonClick(){
        view?.showAddItemActivity()
    }

    fun createConnectionToServer(){
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

        val api = retrofit.create(CityTemp::class.java)

    }
}