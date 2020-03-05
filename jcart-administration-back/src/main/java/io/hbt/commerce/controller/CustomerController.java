package io.hbt.commerce.controller;

import io.hbt.commerce.dto.in.CustomerSearchInDTO;
import io.hbt.commerce.dto.out.CustomerListOutDTO;
import io.hbt.commerce.dto.out.CustomerShowOutDTO;
import io.hbt.commerce.dto.out.PageOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {

    @GetMapping("/search")
    public PageOutDTO<CustomerListOutDTO> search(
            CustomerSearchInDTO customerSearchInDTO,
            @RequestParam Integer pageNum
    ){
        return null;
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
