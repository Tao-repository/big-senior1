package io.hbt.commerce.service;

import io.hbt.commerce.dto.in.CustomerRegisterInDTO;
import io.hbt.commerce.po.Customer;

public interface CustomerService {
    Integer register(CustomerRegisterInDTO customerRegisterInDTO);

    Customer getByUsername(String username);

    Customer getById(Integer customerId);

    void update(Customer customer);

    Customer getByEmail(String email);
}
