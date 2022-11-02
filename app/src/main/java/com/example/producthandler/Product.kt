package com.example.producthandler

import java.io.Serializable

class Product: Serializable {
    var id : Int = 0
    var name: String = ""
    var quantity: Int = 0
    var price: Float = 0.0F

    constructor()

    constructor(name: String, quantity: Int, price: Float){
        this.name = name
        this.quantity = quantity
        this.price = price
    }
}