package com.example.producthandler

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "ProductsDB"
val TABLE_NAME = "Products"
val COL_NAME = "name"
val COL_PRICE = "price"
val COL_QUANTITY = "quantity"

class DatabaseHandler(var ctx: Context) : SQLiteOpenHelper(ctx, DATABASE_NAME, null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        TODO("Not yet implemented")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(product: Product){
        TODO("Not yet implemented")
    }

    fun readData(){
        TODO("Not yet implemented")
    }

    fun deleteData(index: Int){
        TODO("Not yet implemented")
    }

    fun updateData(index: Int, product: Product){
        TODO("Not yet implemented")
    }
}