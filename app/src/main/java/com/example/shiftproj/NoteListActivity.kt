package com.example.shiftproj

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_list_activity.*

class NoteListActivity : AppCompatActivity() {
    private val notes = arrayListOf(
        Note("Новосибирск", "30, солнечно"),
        Note("Питер", "18, дождь"),
        Note("Москва", "18, пасмурно"),
        Note("Бердск", "29, солнечно"),
        Note("Самара", "25, облачно"))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.note_list_activity)

        val params = intent.getStringArrayListExtra("Notes")
        if(params != null){
            notes.add(Note(params[0], params[1]))
        }

        button4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        })

        val adapter = NoteListAdapter()
        adapter.setNoteListener(object : NoteListAdapter.NoteListener{
            override fun onNoteClick(note: Note) {
                val intent = Intent(this@NoteListActivity, NoteDetailActivity::class.java)
                intent.putStringArrayListExtra("Note", arrayListOf(note.title, note.subTitle))
                startActivity(intent)
            }

        })

        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        adapter.setNoteList(notes)
    }
}