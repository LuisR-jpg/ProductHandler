package com.example.producthandler

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import java.text.NumberFormat
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProductRow.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductRow : Fragment(R.layout.fragment_product_row) {
    private var product: Product = Product()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        product = arguments?.getSerializable("PRODUCT") as Product

        val name = view.findViewById<TextView>(R.id.productName)
        val price = view.findViewById<TextView>(R.id.productPrice)
        val quantity = view.findViewById<TextView>(R.id.productQuantity)

        val format: NumberFormat = NumberFormat.getCurrencyInstance()
        format.maximumFractionDigits = 2
        format.currency = Currency.getInstance("MXN")

        name.text = product.name
        price.text = format.format(product.price)
        quantity.text = product.quantity.toString()

        val updateBtn = view.findViewById<Button>(R.id.btnUpdate)
        updateBtn.setOnClickListener {
            Intent(activity, UpdateActivity::class.java).also {
                it.putExtra("PRODUCT", product)
                startActivity(it)
            }
        }

        val deleteBtn = view.findViewById<Button>(R.id.btnDelete)
        deleteBtn.setOnClickListener {
            val builder: AlertDialog.Builder? = activity?.let {
                AlertDialog.Builder(it)
            }
            builder?.apply {
                setPositiveButton("Eliminar",
                    DialogInterface.OnClickListener { dialog, id ->
                        val db = DatabaseHandler(activity?.applicationContext!!)
                        db.deleteData(product.id)
                        val ma = activity as MainActivity
                        ma.refreshProductList()
                    })
                setNegativeButton("Cancelar",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    })
            }
            builder?.setMessage("¿Seguro que quieres elminar el producto " + product.name + "?")
            builder?.setTitle("Confirmar")
            val alert = builder?.create()
            alert?.show()
        }
    }

    companion object {
        fun newInstance(product: Product): ProductRow {
            val fragment = ProductRow()
            val bundle = Bundle()
            bundle.putSerializable("PRODUCT", product)
            fragment.arguments = bundle
            return fragment
        }
    }
}