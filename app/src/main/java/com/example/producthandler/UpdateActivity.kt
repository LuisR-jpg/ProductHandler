package com.example.producthandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class UpdateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        val product = intent.getSerializableExtra("PRODUCT") as Product

        val txtName = findViewById<EditText>(R.id.editTextName)
        val txtPrice = findViewById<EditText>(R.id.editTextPrice)
        val txtQuantity = findViewById<EditText>(R.id.editTextQty)
        val saveBtn = findViewById<Button>(R.id.buttonSave)

        txtName.setText(product.name)
        txtPrice.setText(product.price.toString())
        txtQuantity.setText(product.quantity.toString())

        saveBtn.setOnClickListener {
            val name = txtName.text.toString()
            val price = txtPrice.text.toString()
            val quantity = txtQuantity.text.toString()

            if(price == "" || name == "" || quantity == "") {
                Toast.makeText(applicationContext, "Llena los campos", Toast.LENGTH_SHORT).show()
            }
            else {
                product.name = name
                product.price = price.toFloat()
                product.quantity = quantity.toInt()

                val db = DatabaseHandler(applicationContext)
                db.updateData(product)
                finish()
            }
        }
    }
}