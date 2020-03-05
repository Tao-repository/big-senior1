package io.hbt.commerce.controller;

import io.hbt.commerce.dto.out.AddressListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@CrossOrigin
public class AddressController {

    @GetMapping("/getListByCustomerId")
    public List<AddressListOutDTO> getListByCustomerId(
            @RequestParam Integer customerId
    ){
        return null;
    }

}
