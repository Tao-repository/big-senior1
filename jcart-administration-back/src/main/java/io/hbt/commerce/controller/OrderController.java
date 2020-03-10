package io.hbt.commerce.controller;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.OrderSearchInDTO;
import io.hbt.commerce.dto.out.*;
import io.hbt.commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/search")
    public PageOutDTO<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO,
                                              @RequestParam Integer pageNum){
        Page<OrderListOutDTO> page = orderService.search(orderSearchInDTO, pageNum);

        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(
            @RequestParam Long orderId
    ){
        return null;
    }

    @GetMapping("/getInvoiceInfo")
    public OrderInvoiceShowOutDTO getInvoiceInfo(
            @RequestParam Long orderId
    ){
        return null;
    }

    @GetMapping("/getShipInfo")
    public OrderShipShowOutDTO getShipInfo(
            @RequestParam Long orderId
    ){
        return null;
    }

}
