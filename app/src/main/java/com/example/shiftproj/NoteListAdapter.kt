package com.example.shiftproj

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_note.view.*

class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.ViewHolder>() {

    private val noteList : MutableList<Note> = mutableListOf()
    private var noteListener : NoteListener? = null

    public fun setNoteList(newList : List<Note>){
        noteList.clear()
        noteList.addAll(newList)

        notifyDataSetChanged()
    }

    override fun getItemCount() = noteList.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(noteList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view, noteListener)
    }

    public fun setNoteListener(Listener: NoteListener){
        noteListener = Listener
    }

    class  ViewHolder(itemView : View, private val noteLisener : NoteListener?) : RecyclerView.ViewHolder(itemView){
        private val itemTitle = itemView.itemTitle

        fun bind(note: Note) {
            itemTitle.text = note.title
            itemView.setOnClickListener{
                noteLisener?.onNoteClick(note)
            }
        }
    }

    interface NoteListener{
        fun onNoteClick(note : Note)
    }

}

