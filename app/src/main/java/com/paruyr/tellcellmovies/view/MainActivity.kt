package com.paruyr.tellcellmovies.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.paruyr.tellcellmovies.R
import com.paruyr.tellcellmovies.databinding.ActivityMainBinding
import com.paruyr.tellcellmovies.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var context: Context

    lateinit var mainActivityViewModel: MainActivityViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)


        binding.btnClick.setOnClickListener {

           // wp7progressBar.showProgressBar()

            mainActivityViewModel.getUser()!!.observe(this, Observer { serviceSetterGetter ->

                val msg = serviceSetterGetter.message

                binding.lblResponse.text = msg

            })

        }

    }
}