package com.example.shiftproj.feature.cityTemp.list.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shiftproj.R

import kotlinx.android.synthetic.main.item_city_temp.view.*
import com.example.common.CityTemp

class CitesTempsListAdapter : RecyclerView.Adapter<CitesTempsListAdapter.ViewHolder>() {

    private val cityTempList : MutableList<CityTemp> = mutableListOf()
    private var noteListener : NoteListener? = null

    fun setCitesTempList(newList : List<CityTemp>?){
        cityTempList.clear()
        if(newList == null){
            return
        }
        cityTempList.addAll(newList)

        notifyDataSetChanged()
    }
    fun addItemFromIntent(item : CityTemp?){
        if(item != null){
            cityTempList.add(item)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = cityTempList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cityTempList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_city_temp, parent, false)
        return ViewHolder(
            view,
            noteListener
        )
    }

    fun setNoteListener(Listener: NoteListener){
        noteListener = Listener
    }

    class  ViewHolder(itemView : View, private val noteLisener : NoteListener?) : RecyclerView.ViewHolder(itemView){
        private val itemTitle = itemView.itemTitle

        fun bind(CityTemp: CityTemp) {
            itemTitle.text = CityTemp.city
            itemView.setOnClickListener{
                noteLisener?.onNoteClick(CityTemp)
            }
        }
    }

    interface NoteListener{
        fun onNoteClick(CityTemp : CityTemp)
    }

}

