package com.example.shiftproj.presentation.ui.citesTemp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.shiftproj.R
import com.example.shiftproj.model.entity.CityTemp
import kotlinx.android.synthetic.main.activity_detail.*

class CitesTempsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val params = intent.getSerializableExtra("CityTemp") as CityTemp
        Title.text = params.city
        subTitle.text = params.temp.toString()
    }
}