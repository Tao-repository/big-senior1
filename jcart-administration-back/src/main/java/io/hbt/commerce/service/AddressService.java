package io.hbt.commerce.service;

import io.hbt.commerce.po.Address;

public interface AddressService {


    Address getById(Integer defaultAddressId);
}
