package com.hfad.viewmodelappkotlin.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hfad.viewmodelappkotlin.R
import com.hfad.viewmodelappkotlin.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel
    lateinit var bindind:MainFragmentBinding
    /*var binding_: MainFragmentBinding? = null
    val bindind: MainFragmentBinding
        get(): MainFragmentBinding {
            return binding_!!
        }*/

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
        var observer = Observer<Any> { renderData(it) }
        viewModel.getData().observe(viewLifecycleOwner, observer)
        viewModel.getDataFromLocalSource()
    }

    private fun renderData(data: Any) {
        Toast.makeText(context, "data", Toast.LENGTH_LONG).show()
    }

}