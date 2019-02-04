package com.example.androidfundamentals.collectors;

import com.example.androidfundamentals.converters.AddressConverter;
import com.example.androidfundamentals.domains.Address;
import com.example.androidfundamentals.domains.Addresses;
import com.example.androidfundamentals.repositories.models.AddressModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AddressCollector implements Collector<Address, List<Address>, Addresses> {

    @Override
    public Supplier<List<Address>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Address>, Address> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator<List<Address>> combiner() {
        return (addressList, address) -> {
            addressList.addAll(address);
            return addressList;
        };
    }

    @Override
    public Function<List<Address>, Addresses> finisher() {
        return Addresses::new;
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED));
    }

    public static AddressCollector toAddresses() {
        return new AddressCollector();
    }
}

