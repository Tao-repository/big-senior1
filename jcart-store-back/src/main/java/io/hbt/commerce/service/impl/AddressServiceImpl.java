package io.hbt.commerce.service.impl;

import io.hbt.commerce.dao.AddressMapper;
import io.hbt.commerce.po.Address;
import io.hbt.commerce.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getByCustomerId(Integer customerId) {
        return addressMapper.selectByCustomerId(customerId);
    }

    @Override
    public void create(Address address) {
        addressMapper.insertSelective(address);
    }

    @Override
    public Address getById(Integer shipAddressId) {
        Address address = addressMapper.selectByPrimaryKey(shipAddressId);
        return address;
    }

    @Override
    public void update(Address address) {
        addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public void delete(Integer addressId) {
        addressMapper.deleteByPrimaryKey(addressId);
    }
}
