package io.hbt.commerce.service.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import io.hbt.commerce.dao.CustomerMapper;
import io.hbt.commerce.dto.in.CustomerRegisterInDTO;
import io.hbt.commerce.enumeration.CustomerStatus;
import io.hbt.commerce.po.Customer;
import io.hbt.commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Override
    public Integer register(CustomerRegisterInDTO customerRegisterInDTO) {
        Customer customer = new Customer();
        customer.setUsername(customerRegisterInDTO.getUsername());
        customer.setRealName(customerRegisterInDTO.getRealName());
        customer.setEmail(customerRegisterInDTO.getEmail());
        customer.setEmailVerified(false);
        customer.setMobile(customerRegisterInDTO.getMobile());
        customer.setMobileVerified(false);
        customer.setNewsSubscribed(customerRegisterInDTO.getNewsSubscribed());
        customer.setCreateTime(new Date());
        customer.setStatus((byte) CustomerStatus.Enable.ordinal());
        customer.setRewordPoints(0);

        //加密
        String password = customerRegisterInDTO.getPassword();
        String bcryptHashString = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        customer.setEncryptedPassword(bcryptHashString);

        customerMapper.insertSelective(customer);
        Integer customerId = customer.getCustomerId();
        return customerId;
    }

    @Override
    public Customer getByUsername(String username) {
        Customer customer = customerMapper.getByUsername(username);
        return customer;
    }

    @Override
    public Customer getById(Integer customerId) {
        Customer customer = customerMapper.selectByPrimaryKey(customerId);
        return customer;
    }

    @Override
    public void update(Customer customer) {
        customerMapper.insertSelective(customer);
    }

    @Override
    public Customer getByEmail(String email) {
        Customer customer = customerMapper.getByEmail(email);
        return customer;
    }
}
