package com.example.shiftproj.feature.hello.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shiftproj.R
import com.example.shiftproj.feature.cityTemp.list.presentation.CitesTempsListActivity
import kotlinx.android.synthetic.main.activity_main.*

class HelloActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val intent = Intent(this, CitesTempsListActivity::class.java)
            startActivity(intent)
        }

    }
}
