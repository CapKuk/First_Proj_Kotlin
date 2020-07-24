package com.example.shiftproj

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.add_note_activity.*
import android.view.Gravity
import android.widget.Toast

class AddNoteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note_activity)

        setButton.setOnClickListener(View.OnClickListener {
            if(sityTextView.text == null || sityTextView.text.toString() == "" ||
                weatherTextView.text == null || weatherTextView.text.toString() == ""){
                showToast()
                return@OnClickListener;
            }
            val note = Note(sityTextView.text.toString(), weatherTextView.text.toString())
            val intent = Intent(this, NoteListActivity::class.java)
            intent.putStringArrayListExtra("Notes", arrayListOf(note.title, note.subTitle))
            startActivity(intent)
        })
    }
    private fun showToast() {
        //создаём и отображаем текстовое уведомление
        val toast = Toast.makeText(
            applicationContext,
            "Введены неверные данные. Одна из строк оказалась пуста.",
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.BOTTOM, 0, 0)
        toast.show()
    }
}
