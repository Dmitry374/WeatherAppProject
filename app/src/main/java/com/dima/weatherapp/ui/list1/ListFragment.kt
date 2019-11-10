package com.dima.weatherapp.ui.list1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dima.weatherapp.R
import com.dima.weatherapp.di.component.DaggerFragmentComponent
import com.dima.weatherapp.di.module.FragmentModule
import com.dima.weatherapp.ui.detail.DetailFragment
import com.dima.weatherapp.ui.main.MainActivity
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : Fragment(), ListContract.View {

    @Inject
    lateinit var presenter: ListContract.Presenter

    private lateinit var rootView: View

    companion object {
        val TAG: String = ListFragment::class.java.simpleName
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependency()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attach(this)
        presenter.subscribe()
        initView()

        btnClick.setOnClickListener {
            val fragment = DetailFragment.newInstance()
            (activity as MainActivity).replaceFragment(fragment, DetailFragment.TAG)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.unsubscribe()
    }

    private fun injectDependency() {
        val listComponent = DaggerFragmentComponent.builder()
            .fragmentModule(FragmentModule())
            .build()

        listComponent.inject(this)
    }

    private fun initView() {
//        presenter.loadData()
    }

}