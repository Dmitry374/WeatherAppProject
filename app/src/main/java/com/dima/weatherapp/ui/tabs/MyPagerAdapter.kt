package com.dima.weatherapp.ui.tabs

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.dima.weatherapp.data.model.Model
import com.dima.weatherapp.ui.list.WeatherListFragment

class MyPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private var weatherListFragment: WeatherListFragment? = null
    private lateinit var weatherCity: Model.WeatherCity

    fun setTitlesList(weatherCity: Model.WeatherCity) {
        this.weatherCity = weatherCity
    }

    override fun getItem(position: Int): Fragment? {

        val weatherListFragment: WeatherListFragment = WeatherListFragment()
            .newInstance(weatherCity.list[position])
        return weatherListFragment
    }

    override fun getCount(): Int {
        return weatherCity.list.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return weatherCity.list[position].name
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        if (getBlankFragment() != `object`) {
            weatherListFragment = `object` as WeatherListFragment
        }
        super.setPrimaryItem(container, position, `object`)
    }

    private fun getBlankFragment(): WeatherListFragment? {
        return weatherListFragment
    }
}