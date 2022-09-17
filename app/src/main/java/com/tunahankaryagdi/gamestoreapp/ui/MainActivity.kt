package com.tunahankaryagdi.gamestoreapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tunahankaryagdi.gamestoreapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}