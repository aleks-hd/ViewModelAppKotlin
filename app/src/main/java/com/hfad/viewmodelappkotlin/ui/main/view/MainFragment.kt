package com.hfad.viewmodelappkotlin.ui.main.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.hfad.viewmodelappkotlin.databinding.MainFragmentBinding
import com.hfad.viewmodelappkotlin.ui.main.viewmodel.AppState
import com.hfad.viewmodelappkotlin.ui.main.viewmodel.MainViewModel

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var bindind: MainFragmentBinding

    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bindind = MainFragmentBinding.inflate(inflater, container, false)
        return bindind.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //var observer = Observer<Any> { renderData(it) }
        viewModel.getData().observe(viewLifecycleOwner, Observer { renderData(it) })
        viewModel.getDataFromLocalSource()
        viewModel.getWeather()

    }

    private fun renderData(data: AppState) {
        Toast.makeText(context, "data", Toast.LENGTH_LONG).show()
        when (data) {
            is AppState.Error -> TODO()
            is AppState.Success -> {
                bindind.loadingLayout.visibility = View.GONE
                Snackbar.make(bindind.mainView, "Success", Snackbar.LENGTH_LONG).show()
                setDate(data)
            }
            AppState.Loading -> {
                bindind.loadingLayout.visibility = View.VISIBLE
            }
        }
    }
    private fun setDate(data: AppState.Success){
        bindind.cityCoordinates.text =
            "${data.dataWeather.city.lat} ${data.dataWeather.city.long}"
        bindind.cityName.text = data.dataWeather.city.city
        bindind.feelsLikeValue.text = data.dataWeather.temperature.toString()
        bindind.temperatureValue.text = data.dataWeather.feelalike.toString()

    }

}
