package com.example.kacparaappmainpage

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var productsLV: ListView

    lateinit var listAdapter: ArrayAdapter<String>

    lateinit var productList: ArrayList<String>

    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productsLV = findViewById(R.id.idLVProducts)
        searchView = findViewById(R.id.idSV)

        productList = ArrayList()
        productList.add("Çikolata")
        productList.add("Su")
        productList.add("Cips")
        productList.add("Kola")
        productList.add("Sabun")

        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            productList
        )

        productsLV.adapter = listAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // on below line we are checking
                // if query exist or not.
                if (productList.contains(query)) {
                    // if query exist within list we
                    // are filtering our list adapter.
                    listAdapter.filter.filter(query)
                } else {
                    // if query is not present we are displaying
                    // a toast message as no  data found..
                    Toast.makeText(this@MainActivity, "Aradığınız ürün bulunamadı.", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                // if query text is change in that case we
                // are filtering our adapter with
                // new text on below line.
                listAdapter.filter.filter(newText)
                return false
            }
        })
    }
}