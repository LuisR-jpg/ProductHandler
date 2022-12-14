package com.example.producthandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        val txtName = findViewById<EditText>(R.id.editTextName)
        val txtPrice = findViewById<EditText>(R.id.editTextPrice)
        val txtQuantity = findViewById<EditText>(R.id.editTextQty)
        val saveBtn = findViewById<Button>(R.id.buttonSave)

        saveBtn.setOnClickListener {
            val name = txtName.text.toString()
            val price = txtPrice.text.toString()
            val quantity = txtQuantity.text.toString()

            if(price == "" || name == "" || quantity == "") {
                Toast.makeText(applicationContext, "Llena los campos", Toast.LENGTH_SHORT).show()
            }
            else {
                val newProduct = Product(name, quantity.toInt(), price.toFloat())
                val db = DatabaseHandler(applicationContext)
                db.insertData(newProduct)
                finish()
            }
        }
    }
}