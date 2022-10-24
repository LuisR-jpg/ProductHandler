package com.example.producthandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val saveBtn = findViewById<Button>(R.id.buttonSave)

        saveBtn.setOnClickListener {
            finish()
        }
    }
}