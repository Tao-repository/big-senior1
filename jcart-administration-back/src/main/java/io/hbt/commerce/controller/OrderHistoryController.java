package io.hbt.commerce.controller;


import io.hbt.commerce.dto.in.OrderHistoryCreateInDTO;
import io.hbt.commerce.dto.out.OrderHistoryListOutDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orderhistory")
@CrossOrigin
public class OrderHistoryController {

    @GetMapping("/getListByOrderId")
    public List<OrderHistoryListOutDTO> getListByOrderId(
            @RequestParam Long orderId
    ){
        return null;
    }

    @PostMapping("/create")
    public Integer create(
            @RequestBody OrderHistoryCreateInDTO orderHistoryCreateInDTO
    ){
        return null;
    }
}
