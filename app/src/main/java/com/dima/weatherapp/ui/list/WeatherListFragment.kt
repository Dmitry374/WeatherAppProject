package com.dima.weatherapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dima.weatherapp.App
import com.dima.weatherapp.R
import com.dima.weatherapp.data.model.Model
import kotlinx.android.synthetic.main.fragment_weather_list.*
import javax.inject.Inject

class WeatherListFragment : Fragment(), WeatherListContract.View {

    @Inject
    lateinit var presenter: WeatherListContract.Presenter

    private val WEATHER_LIST_ITEM = "weather_list_item"

    private lateinit var modelListItem: Model.List

    private lateinit var rootView: View

    fun newInstance(modelListItem: Model.List): WeatherListFragment {
        val fragment = WeatherListFragment()
        val args = Bundle()
        args.putParcelable(WEATHER_LIST_ITEM, modelListItem)
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        retainInstance = true
        if (arguments != null) {
            modelListItem = arguments!!.getParcelable(WEATHER_LIST_ITEM)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_weather_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()

        tvtext.text = modelListItem.name
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    private fun initView() {
//        presenter.loadData()
    }

}