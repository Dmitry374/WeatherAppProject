package com.dima.weatherapp.ui.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dima.weatherapp.App
import com.dima.weatherapp.R
import com.dima.weatherapp.data.model.Model
import kotlinx.android.synthetic.main.tabs_fragment.*
import javax.inject.Inject

class TabsFragment : Fragment(), TabsContract.View {

    @Inject
    lateinit var presenter: TabsContract.Presenter

    private lateinit var rootView: View

    private val WEATHER = "weather"

    private lateinit var weatherCity: Model.WeatherCity

    companion object {
        val TAG: String = TabsFragment::class.java.simpleName
    }

    fun newInstance(weatherCity: Model.WeatherCity): TabsFragment {
        val fragment = TabsFragment()
        val args = Bundle()
        args.putParcelable(WEATHER, weatherCity)
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        retainInstance = true
        if (arguments != null) {
            weatherCity = arguments!!.getParcelable(WEATHER)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.tabs_fragment, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()

        showList(weatherCity)
    }

    private fun showList(weatherCity: Model.WeatherCity) {
        val fragmentAdapter = MyPagerAdapter(activity?.supportFragmentManager)
        fragmentAdapter.setTitlesList(weatherCity)
        viewpager_main.adapter = fragmentAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

}