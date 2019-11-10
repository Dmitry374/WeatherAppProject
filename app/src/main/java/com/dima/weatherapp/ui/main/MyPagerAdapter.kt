package com.dima.weatherapp.ui.main

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.dima.weatherapp.ui.list.WeatherListFragment

class MyPagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {

    private lateinit var weatherListFragment: WeatherListFragment
    private var fragmentTitleList = ArrayList<String>()

    fun setTitlesList(fragmentTitleList: List<String>) {
        this.fragmentTitleList = fragmentTitleList as ArrayList<String>
    }

    override fun getItem(position: Int): Fragment? {

        var weatherListFragment: WeatherListFragment = WeatherListFragment()
            .newInstance(fragmentTitleList[position])
        if (position == 0) {
            this.weatherListFragment = weatherListFragment
        }
        return weatherListFragment
    }

    override fun getCount(): Int {
        return fragmentTitleList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
        if (getBlankFragment() != `object`) {
            weatherListFragment = `object` as WeatherListFragment
        }
        super.setPrimaryItem(container, position, `object`)
    }

    private fun getBlankFragment(): WeatherListFragment {
        return weatherListFragment
    }
}