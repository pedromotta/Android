package com.example.androidfundamentals.converters;

import com.example.androidfundamentals.domains.Address;
import com.example.androidfundamentals.repositories.models.AddressModel;

public class AddressConverter {

    public static Address modelToDomain(AddressModel addressModel) {
        return new Address(addressModel.getCep(), addressModel.getLogradouro(), addressModel.getComplemento(),
                addressModel.getBairro(), addressModel.getCidade(), addressModel.getUf()
        );
    }

    public static AddressModel domainToModel(Address address) {
        AddressModel model = new AddressModel();
        model.setCep(address.getCep());
        model.setLogradouro(address.getLogradouro());
        model.setComplemento(address.getComplemento());
        model.setBairro(address.getBairro());
        model.setCidade(address.getCidade());
        model.setUf(address.getUf());
        return model;
    }
}
