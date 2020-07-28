package com.example.shiftproj.presentation.ui.citesTemp.add

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_note_activity.*
import android.view.Gravity
import android.widget.Toast
import com.example.shiftproj.R
import com.example.shiftproj.model.entity.CityTemp
import com.example.shiftproj.presentation.presenters.city_temp.add.AddCitesTempsPresenter
import com.example.shiftproj.presentation.ui.citesTemp.list.CitesTempsListActivity

class AddCityTempActivity : AppCompatActivity(), AddCityTempView {
    private val presenter = AddCitesTempsPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note_activity)
        presenter.attachView(this)

        setButton.setOnClickListener {
            presenter.onAddButtonClick(
                sityTextView.text?.toString(),
                weatherTextView.text?.toString())
        }
    }
    fun showToast() {
        //создаём и отображаем текстовое уведомление
        val toast = Toast.makeText(
            applicationContext,
            "Введены неверные данные. Одна из строк оказалась пуста.",
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.show()
    }

    override fun onAddButtonClick(city: String, temp: Int) {
        val intent = Intent(this, CitesTempsListActivity::class.java)
        intent.putExtra("Notes", CityTemp(city, temp))
        startActivity(intent)
    }
}
