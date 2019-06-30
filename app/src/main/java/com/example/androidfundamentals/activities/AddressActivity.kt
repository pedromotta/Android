package com.example.androidfundamentals.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.example.androidfundamentals.R
import com.example.androidfundamentals.domains.Address
import com.example.androidfundamentals.domains.Addresses
import com.example.androidfundamentals.presenters.AddressPresenter
import com.google.android.material.snackbar.Snackbar

import javax.inject.Inject

import dagger.android.AndroidInjection

class AddressActivity : AppCompatActivity() {

    @Inject
    lateinit var addressPresenter: AddressPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        Log.i(this.javaClass.name, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(this.javaClass.name, "onStart")
        refreshList()
    }

    fun onClickSearchCepButton(view: View) {
        val cepTextView = findViewById<TextView>(R.id.cep_text)
        val cep = cepTextView.text.toString()

        addressPresenter.searchAddress(cep)
    }

    fun refreshAddressList(addresses: Addresses) {
        val addressListView = findViewById<ListView>(R.id.address_list)
        val addressArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, addresses.toList())
        addressListView.adapter = addressArrayAdapter
    }

    fun updateAddressData(address: Address) {
        fillAddress(address)
        refreshList()
    }

    private fun refreshList() {
        this.addressPresenter.refreshAddressList()
    }

    fun showAddressNotFoundMessage() {
        Snackbar.make(findViewById(R.id.address_layout), "Endereço não encontrado", Snackbar.LENGTH_SHORT).show()
    }

    private fun fillAddress(address: Address) {
        val addressField = findViewById<TextView>(R.id.address_text)
        addressField.text = address.toText()
    }
}
