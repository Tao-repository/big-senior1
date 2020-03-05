package io.hbt.commerce.service;

import io.hbt.commerce.po.Address;

import java.util.List;

public interface AddressService {
    List<Address> getByCustomerId(Integer customerId);

    void create(Address address);

    Address getById(Integer shipAddressId);

    void update(Address address);

    void delete(Integer addressId);
}
