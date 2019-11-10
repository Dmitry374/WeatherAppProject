package com.dima.weatherapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dima.weatherapp.R
import com.dima.weatherapp.di.component.DaggerActivityComponent
import com.dima.weatherapp.di.module.ActivityModule

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        injectDependency()
    }

    private fun injectDependency() {
        val activityComponent = DaggerActivityComponent.builder()
            .activityModule(ActivityModule(this))
            .build()

        activityComponent.inject(this)
    }
}
