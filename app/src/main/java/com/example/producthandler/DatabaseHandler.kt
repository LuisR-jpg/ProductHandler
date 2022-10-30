package com.example.producthandler

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

const val DATABASE_NAME = "ProductsDB"
const val TABLE_NAME = "Products"
const val COL_NAME = "name"
const val COL_PRICE = "price"
const val COL_QUANTITY = "quantity"
const val COL_ID = "ID"

class DatabaseHandler(var ctx: Context) : SQLiteOpenHelper(ctx, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable  = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_NAME + " VARCHAR(255)," +
                COL_PRICE + " REAL," +
                COL_QUANTITY + " INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(product: Product): Boolean{
        val db = this.writableDatabase
        var cv = ContentValues()

        cv.put(COL_NAME, product.name)
        cv.put(COL_PRICE, product.price)
        cv.put(COL_QUANTITY, product.quantity)

        var result = db.insert(TABLE_NAME, null, cv)

        /* You can keep this, if it works for you
        if(result == (-1).toLong())
            Toast.makeText(ctx, "Insertion failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(ctx, "Successfully inserted", Toast.LENGTH_SHORT).show()
         */
        return result != (-1).toLong()
    }

    fun readData(): MutableList<Product>{
        var list: MutableList<Product> = ArrayList()
        val db = this.readableDatabase
        val query = "Select * from $TABLE_NAME";
        val result = db.rawQuery(query, null)
        if(result.moveToFirst()){
            do {
                var product = Product()
                product.id = result.getString(0).toInt()
                product.name = result.getString(1)
                product.price = result.getString(2).toFloat()
                product.quantity = result.getString(3).toInt()

                list.add(product)
            } while(result.moveToNext())
        }
        result.close()
        db.close()
        return list
    }

    fun deleteData(index: Int): Boolean{
        val db = this.writableDatabase
        val r = db.delete(TABLE_NAME, "$COL_ID=$index", null)
        db.close()
        return r == 1
    }

    fun updateData(product: Product): Boolean{
        val db = this.writableDatabase
        val values = ContentValues()

        values.put(COL_NAME, product.name)
        values.put(COL_PRICE, product.price)
        values.put(COL_QUANTITY, product.quantity)

        val r = db.update(TABLE_NAME, values, "$COL_ID=${product.id}", null)
        db.close()
        return r == 1
    }
}