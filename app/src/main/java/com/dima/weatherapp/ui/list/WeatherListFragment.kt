package com.dima.weatherapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dima.weatherapp.App
import com.dima.weatherapp.R
import kotlinx.android.synthetic.main.fragment_weather_list.*
import javax.inject.Inject

class WeatherListFragment : Fragment(), WeatherListContract.View {

    @Inject
    lateinit var presenter: WeatherListContract.Presenter

    private val ARG_PARAM1 = "param1"

    private var mParam1: String? = null

    private lateinit var rootView: View

    fun newInstance(param1: String): WeatherListFragment {
        val fragment = WeatherListFragment()
        val args = Bundle()
        args.putString(ARG_PARAM1, param1)
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        retainInstance = true
        if (arguments != null) {
            mParam1 = arguments!!.getString(ARG_PARAM1)
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

        tvtext.setText("Page number: $mParam1")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    private fun initView() {
//        presenter.loadData()
    }

}