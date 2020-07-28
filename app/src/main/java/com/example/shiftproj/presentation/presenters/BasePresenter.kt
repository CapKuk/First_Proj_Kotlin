package com.example.shiftproj.presentation.presenters

import com.example.shiftproj.presentation.ui.ViewContract

open class BasePresenter<View : ViewContract> {
    var view : View? = null
    fun attachView(view : View){
        this.view = view
        onViewAttached()
    }
    open fun onViewAttached(){}
    fun detachView(){
        view = null
    }
}
