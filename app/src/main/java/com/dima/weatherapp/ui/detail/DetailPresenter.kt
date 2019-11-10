package com.dima.weatherapp.ui.detail

class DetailPresenter : DetailContract.Presenter {

    private lateinit var view: DetailContract.View

    override fun subscribe() {

    }

    override fun unsubscribe() {

    }

    override fun attach(view: DetailContract.View) {
        this.view = view
    }
}