package com.dima.weatherapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dima.weatherapp.App
import com.dima.weatherapp.R
import javax.inject.Inject

class DetailFragment : Fragment(), DetailContract.View {

    @Inject
    lateinit var presenter: DetailContract.Presenter

    private lateinit var rootView: View

    companion object {
        val TAG: String = DetailFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = DetailFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_detail, container, false)
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
//        presenter.loadData()
    }

}