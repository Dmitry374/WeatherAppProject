package com.dima.weatherapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dima.weatherapp.R
import com.dima.weatherapp.di.component.DaggerActivityComponent
import com.dima.weatherapp.di.module.ActivityModule
import com.dima.weatherapp.ui.detail.DetailFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()

        presenter.attach(this)

        var list: List<String> = arrayListOf("One", "Two", "Three")

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager)
        fragmentAdapter.setTitlesList(list)
        viewpager_main.adapter = fragmentAdapter

    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }

    override fun showListFragment() {
//        supportFragmentManager.beginTransaction()
//            .disallowAddToBackStack()
//            .replace(R.id.frame, ListFragment.newInstance(), ListFragment.TAG)
//            .commit()
    }

    override fun replaceFragment(fragment: Fragment, tag: String) {
//        supportFragmentManager.beginTransaction()
//            .setCustomAnimations(AnimType.SLIDE.getAnimPair().first, AnimType.SLIDE.getAnimPair().second)
//            .replace(R.id.frame, fragment, tag).addToBackStack("")
//            .commit()
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
