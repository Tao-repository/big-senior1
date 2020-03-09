package io.hbt.commerce.service.impl;

import io.hbt.commerce.dao.AddressMapper;
import io.hbt.commerce.po.Address;
import io.hbt.commerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;


    @Override
    public Address getById(Integer addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        return address;
    }
}
