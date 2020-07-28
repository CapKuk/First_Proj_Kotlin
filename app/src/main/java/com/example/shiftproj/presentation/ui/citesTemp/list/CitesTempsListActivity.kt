package com.example.shiftproj.presentation.ui.citesTemp.list

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shiftproj.R
import com.example.shiftproj.model.entity.CityTemp
import com.example.shiftproj.presentation.presenters.city_temp.list.CitesTempsListPresenter
import com.example.shiftproj.presentation.ui.citesTemp.add.AddCityTempActivity
import com.example.shiftproj.presentation.ui.citesTemp.CitesTempsDetailActivity
import kotlinx.android.synthetic.main.note_list_activity.*

class CitesTempsListActivity : AppCompatActivity(), CitesTempListView {
    private val adapter = CitesTempsListAdapter()
    val presenter = CitesTempsListPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_list_activity)

        presenter.attachView(this)

        val params = intent.getSerializableExtra("Notes") as CityTemp?
        adapter.addItemFromIntent(params)

        button4.setOnClickListener {
            presenter.onAddButtonClick()
        }

        adapter.setNoteListener(object : CitesTempsListAdapter.NoteListener {
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