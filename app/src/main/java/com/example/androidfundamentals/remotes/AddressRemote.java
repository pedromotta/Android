package com.example.androidfundamentals.remotes;

import android.util.Log;

import com.example.androidfundamentals.domains.Address;
import com.example.androidfundamentals.remotes.clients.AddressClient;
import com.example.androidfundamentals.remotes.clients.responses.CepResponse;
import com.example.androidfundamentals.remotes.clients.responses.CepResponseNull;

import javax.inject.Inject;

public class AddressRemote {

    public AddressClient addressClient;

    @Inject
    public AddressRemote(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    public Address getAddressByCep(final String cep) {

        CepResponse cepResponse = addressClient.get(cep);

        if (cepResponse instanceof CepResponseNull) {
            throw new RuntimeException("Cep null");
        }

        Address address = new Address(cep, cepResponse.getLogradouro(), cepResponse.getComplemento(),
                cepResponse.getBairro(), cepResponse.getLocalidade(), cepResponse.getUf());

        Log.i(this.getClass().getName(), address.toString());

        return address;
    }
}
