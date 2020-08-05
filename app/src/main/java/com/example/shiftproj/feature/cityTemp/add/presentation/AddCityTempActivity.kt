package com.example.shiftproj.feature.cityTemp.add.presentation

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.shiftproj.R
import com.example.shiftproj.feature.cityTemp.list.presentation.CitesTempsListActivity
import kotlinx.android.synthetic.main.add_city_temp_activity.*
import com.example.common.CityTemp

class AddCityTempActivity : AppCompatActivity(),
    AddCityTempView {
    private val presenter =
        AddCitesTempsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_city_temp_activity)
        viewModelScope.launch {
            try {
                presenter.attachView(this)
            } catch (e: Exception) {
                // show error
            }
        }

        setButton.setOnClickListener {
            presenter.onAddButtonClick(sityTextView.text?.toString())
        }
    }
    fun showToast(message : String) {
        //создаём и отображаем текстовое уведомление
        val toast = Toast.makeText(
            applicationContext,
            message,
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.show()
    }

    override fun onAddButtonClick(city: String, temp: Double) {
        val intent = Intent(this, CitesTempsListActivity::class.java)
        intent.putExtra("Notes", CityTemp(city, temp))
        startActivity(intent)
    }
}
