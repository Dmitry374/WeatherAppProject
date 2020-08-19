package com.dima.weatherapp.ui.tabs

class TabsPresenter : TabsContract.Presenter {

    private lateinit var view: TabsContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: TabsContract.View) {
        this.view = view
    }
}