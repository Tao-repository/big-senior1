package io.hbt.commerce.service;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.CustomerSearchInDTO;
import io.hbt.commerce.po.Customer;

public interface CustomerService {

    Page<Customer> search(CustomerSearchInDTO customerSearchInDTO, Integer pageNum);

    Customer getById(Integer customerId);

}
