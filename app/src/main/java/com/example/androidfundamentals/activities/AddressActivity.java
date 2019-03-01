package com.example.androidfundamentals.activities;

import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.androidfundamentals.MainApplication;
import com.example.androidfundamentals.R;
import com.example.androidfundamentals.domains.Address;
import com.example.androidfundamentals.domains.Addresses;
import com.example.androidfundamentals.presenters.AddressPresenter;

import javax.inject.Inject;

public class AddressActivity extends AppCompatActivity {

    @Inject
    AddressPresenter addressPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ((MainApplication) getApplication()).buildComponent().inject(this);
        addressPresenter.setActivity(this);

        Log.i(this.getClass().getName(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(this.getClass().getName(), "onStart");
        refreshList();
    }

    public void onClickSearchCepButton(View view) {
        TextView cepTextView = findViewById(R.id.cep_text);
        String cep = cepTextView.getText().toString();

        addressPresenter.searchAddress(cep);
    }

    public void refreshAddressList(Addresses addresses) {
        ListView addressListView = findViewById(R.id.address_list);
        ArrayAdapter<Address> addressArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, addresses.toList());
        addressListView.setAdapter(addressArrayAdapter);
    }

    public void updateAddressData(Address address) {
        fillAddress(address);
        refreshList();
    }

    private void refreshList() {
        this.addressPresenter.refreshAddressList();
    }

    public void showAddressNotFoundMessage() {
        Snackbar.make(findViewById(R.id.address_layout), "Endereço não encontrado", Snackbar.LENGTH_SHORT).show();
    }

    private void fillAddress(Address address) {
        TextView addressField = findViewById(R.id.address_text);
        addressField.setText(address.toText());
    }
}
