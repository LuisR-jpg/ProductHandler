package com.example.producthandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBtn = findViewById<Button>(R.id.buttonAdd)

        refreshProductList()

        addBtn.setOnClickListener {
            Intent(this, AddActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        refreshProductList()
    }

    public fun refreshProductList() {
        val productView = findViewById<LinearLayout>(R.id.productView)
        productView.removeAllViews()
        val db = DatabaseHandler(this)
        val products = db.readData()

        products.forEach {product ->
            val pr = ProductRow.newInstance(product)
            val fv = FrameLayout(this)
            fv.id = View.generateViewId()
            supportFragmentManager.beginTransaction().apply {
                replace(fv.id, pr)
                commit()
            }
            productView.addView(fv)
            productView.invalidate()
        }
    }
}