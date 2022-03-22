package com.example.viewmodelfactoryexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    lateinit var txtCounter : TextView
    lateinit var btn : Button
    lateinit var  mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtCounter = findViewById(R.id.txtCounter)
        //parameterized  view model
        mainViewModel = ViewModelProvider(this, ViewModelFactory(15)).get(MainViewModel::class.java)

        btn = findViewById(R.id.btn)
        btn.setOnClickListener{
            increment()
        }
        setText()
    }

    fun increment()
    {
        mainViewModel.increment()
        setText()
    }

    fun setText()
    {
        txtCounter.text = mainViewModel.count.toString()
    }
}