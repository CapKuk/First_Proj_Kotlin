package com.example.shiftproj.feature.util

open class BasePresenter<View : ViewContract> {
    var view : View? = null
    suspend fun attachView(view : View){
        this.view = view
        onViewAttached()
    }
    open suspend fun onViewAttached(){}
    fun detachView(){
        view = null
    }
}
