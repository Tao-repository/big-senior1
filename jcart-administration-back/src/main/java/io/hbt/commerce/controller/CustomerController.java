package io.hbt.commerce.controller;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.CustomerSearchInDTO;
import io.hbt.commerce.dto.out.CustomerListOutDTO;
import io.hbt.commerce.dto.out.CustomerShowOutDTO;
import io.hbt.commerce.dto.out.PageOutDTO;
import io.hbt.commerce.po.Customer;
import io.hbt.commerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(CustomerSearchInDTO customerSearchInDTO,
                                                 @RequestParam(required = false, defaultValue = "1") Integer pageNum){
        Page<Customer> page = customerService.search(customerSearchInDTO, pageNum);
        List<CustomerListOutDTO> customerListOutDTOS = page.stream().map(customer -> {
            CustomerListOutDTO customerListOutDTO = new CustomerListOutDTO();
            customerListOutDTO.setCustomerId(customer.getCustomerId());
            customerListOutDTO.setUsername(customer.getUsername());
            customerListOutDTO.setRealName(customer.getRealName());
            customerListOutDTO.setMobile(customer.getMobile());
            customerListOutDTO.setEmail(customer.getEmail());
            customerListOutDTO.setStatus(customer.getStatus());
            customerListOutDTO.setCreateTimestamp(customer.getCreateTime().getTime());
            return customerListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<CustomerListOutDTO> pageOutDTO = new PageOutDTO<>();

        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(customerListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public CustomerShowOutDTO getById(
            @RequestParam Integer customerId
    ){
        return null;
    }

    @PostMapping("/disable")
    public void disable(
            @RequestParam Integer customerId
    ){

    }

}
