package com.dima.weatherapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.dima.weatherapp.App
import com.dima.weatherapp.R
import com.dima.weatherapp.data.internaldata.Repository
import com.dima.weatherapp.data.model.Model
import com.dima.weatherapp.ui.detail.DetailFragment
import com.dima.weatherapp.ui.tabs.TabsFragment
import com.dima.weatherapp.util.Constants.Companion.KIEV_CITY_ID
import com.dima.weatherapp.util.Constants.Companion.LONDON_CITY_ID
import com.dima.weatherapp.util.Constants.Companion.MOSCOW_CITY_ID
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    @Inject
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)

        presenter.loadData("$MOSCOW_CITY_ID,$KIEV_CITY_ID,$LONDON_CITY_ID")

    }

    override fun showTabsFragment(weatherCity: Model.WeatherCity) {
        supportFragmentManager.beginTransaction()
            .disallowAddToBackStack()
            .replace(R.id.frame, TabsFragment().newInstance(weatherCity), TabsFragment.TAG)
            .commit()
    }

    override fun replaceFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(AnimType.SLIDE.getAnimPair().first, AnimType.SLIDE.getAnimPair().second)
            .replace(R.id.frame, fragment, tag).addToBackStack("")
            .commit()
    }

    override fun nextFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(AnimType.SLIDE.getAnimPair().first, AnimType.SLIDE.getAnimPair().second)
            .add(R.id.frame, fragment, tag).addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        val fragmentManager = supportFragmentManager
        val fragment = fragmentManager.findFragmentByTag(DetailFragment.TAG)

        if (fragment == null) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }

    enum class AnimType {
        SLIDE,
        FADE;

        fun getAnimPair(): Pair<Int, Int> {
            when(this) {
                SLIDE -> return Pair(R.anim.slide_left, R.anim.slide_right)
                FADE -> return Pair(R.anim.fade_in, R.anim.fade_out)
                else -> {
                    return Pair(R.anim.slide_left, R.anim.slide_right)
                }
            }

        }
    }
}
