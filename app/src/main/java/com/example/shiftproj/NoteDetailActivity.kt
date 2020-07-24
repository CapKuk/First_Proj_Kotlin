package com.example.shiftproj

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class NoteDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val params = intent.getStringArrayListExtra("Note")
        Title.text = params?.get(0)
        subTitle.text = params?.get(1)
    }
}