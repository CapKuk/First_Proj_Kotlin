package com.example.shiftproj.feature.cityTemp.list.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shiftproj.R
import com.example.shiftproj.feature.cityTemp.add.presentation.AddCityTempActivity
import com.example.shiftproj.feature.cityTemp.detail.presentation.CitesTempsDetailActivity
import kotlinx.android.synthetic.main.city_temp_list_activity.*
import com.example.common.CityTemp

class CitesTempsListActivity : AppCompatActivity(),
    CitesTempListView {
    private val adapter =
        CitesTempsListAdapter()
    val presenter =
        CitesTempsListPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_temp_list_activity)

        viewModelScope.launch {
            try {
                presenter.attachView(this)
            } catch (e: Exception) {
                // show error
            }
        }

        val params = intent.getSerializableExtra("Notes") as CityTemp?
        adapter.addItemFromIntent(params)

        button4.setOnClickListener {
            presenter.onAddButtonClick()
        }

        adapter.setNoteListener(object :
            CitesTempsListAdapter.NoteListener {
            override fun onNoteClick(CityTemp: CityTemp) = presenter.onCityTempClick(CityTemp)
        })

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
    }

    override fun setCitesTempsList(cites_temps: List<CityTemp>?) {
        adapter.setCitesTempList(cites_temps)
    }

    override fun showCitesTempsDetails(cites_temps: CityTemp) {
        val intent = Intent(this@CitesTempsListActivity, CitesTempsDetailActivity::class.java)
        intent.putExtra("CityTemp", cites_temps)
        startActivity(intent)
    }

    override fun showAddItemActivity() {
        val intent = Intent(this, AddCityTempActivity::class.java)
        startActivity(intent)
    }
}