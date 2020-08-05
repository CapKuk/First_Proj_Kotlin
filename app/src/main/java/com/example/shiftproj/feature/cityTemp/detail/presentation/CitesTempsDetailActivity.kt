package com.example.shiftproj.feature.cityTemp.detail.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shiftproj.R
import kotlinx.android.synthetic.main.activity_detail.*
import com.example.common.CityTemp

class CitesTempsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val params = intent.getSerializableExtra("CityTemp") as CityTemp
        Title.text = params.city
        subTitle.text = params.temp.toString()
    }
}