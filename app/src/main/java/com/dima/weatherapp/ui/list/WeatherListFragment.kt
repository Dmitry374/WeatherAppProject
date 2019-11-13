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
import java.text.SimpleDateFormat
import javax.inject.Inject
import kotlin.math.roundToInt


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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    private fun initView() {
        tvMain.text = modelListItem.weather[0].main
        tvDescription.text = modelListItem.weather[0].description
        tvDate.text = getDateTime(modelListItem.dt)

        tvTemp.text = getString(R.string.temp, modelListItem.main.temp.roundToInt())
        tvPressure.text = getString(R.string.pressure, modelListItem.main.pressure)
        tvHumidity.text = getString(R.string.humidity, modelListItem.main.humidity)
        tvTempMin.text = getString(R.string.temp_min, modelListItem.main.temp_min)
        tvTempMax.text = getString(R.string.temp_max, modelListItem.main.temp_max)
    }

    private fun getDateTime(seconds: Int): String? {
        return try {
            val sdf = SimpleDateFormat("dd.MM.yyyy")
            val date = java.util.Date(seconds * 1000L)
            sdf.format(date)
        } catch (e: Exception) {
            e.toString()
        }
    }

}