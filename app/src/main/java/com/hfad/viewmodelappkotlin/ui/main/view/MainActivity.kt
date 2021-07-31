package com.hfad.viewmodelappkotlin.ui.main.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.viewmodelappkotlin.R
import com.hfad.viewmodelappkotlin.databinding.MainActivityBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}