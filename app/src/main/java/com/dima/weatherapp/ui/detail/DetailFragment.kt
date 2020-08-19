package com.dima.weatherapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dima.weatherapp.App
import com.dima.weatherapp.R
import com.dima.weatherapp.data.internaldata.Repository
import com.dima.weatherapp.data.model.Model
import kotlinx.android.synthetic.main.fragment_detail.*
import kotlinx.android.synthetic.main.fragment_weather_list.tvDate
import kotlinx.android.synthetic.main.fragment_weather_list.tvDescription
import java.text.SimpleDateFormat
import javax.inject.Inject

class DetailFragment : Fragment(), DetailContract.View {

    private val LIST_ITEM = "list_item"

    @Inject
    lateinit var presenter: DetailContract.Presenter

    @Inject
    lateinit var repository: Repository

    private lateinit var rootView: View

    private lateinit var modelListItem: Model.List

    companion object {
        val TAG: String = DetailFragment::class.java.simpleName
    }

    fun newInstance(modelListItem: Model.List): DetailFragment {
        val fragment = DetailFragment()
        val args = Bundle()
        args.putParcelable(LIST_ITEM, modelListItem)
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.getAppComponent().inject(this)
        super.onCreate(savedInstanceState)

        if (arguments != null) {
            modelListItem = arguments!!.getParcelable(LIST_ITEM)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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
        tvWeatherState.text = modelListItem.weather[0].main
        tvDescription.text = getString(R.string.description_word, modelListItem.weather[0].description)
        tvDate.text = getDateTime(modelListItem.dt)
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