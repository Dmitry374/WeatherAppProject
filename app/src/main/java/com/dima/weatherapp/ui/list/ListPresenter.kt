package com.dima.weatherapp.ui.list

class ListPresenter : ListContract.Presenter {

    private lateinit var view: ListContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: ListContract.View) {
        this.view = view
    }
}