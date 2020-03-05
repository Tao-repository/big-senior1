package io.hbt.commerce.controller;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.OrderCheckoutInDTO;
import io.hbt.commerce.dto.out.OrderListOutDTO;
import io.hbt.commerce.dto.out.OrderShowOutDTO;
import io.hbt.commerce.dto.out.PageOutDTO;
import io.hbt.commerce.po.Order;
import io.hbt.commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/checkout")
    public Long checkout(
            @RequestBody OrderCheckoutInDTO orderCheckoutInDTO,
            @RequestAttribute Integer customerId
    ){
        Long orderId = orderService.checkout(orderCheckoutInDTO, customerId);
        return orderId;
    }

    @GetMapping("/getList")
    public PageOutDTO<OrderListOutDTO> getList(
            @RequestParam(required = false,defaultValue = "1")Integer pageNum,
            @RequestAttribute Integer customerId
    ){
        Page<Order> page = orderService.getByCustomerId(pageNum, customerId);

        List<OrderListOutDTO> OrderListOutDTOS = page.stream().map(order -> {
            OrderListOutDTO orderListOutDTO = new OrderListOutDTO();
            orderListOutDTO.setOrderId(order.getOrderId());
            orderListOutDTO.setStatus(order.getStatus());
            orderListOutDTO.setTotalPrice(order.getTotalPrice());
            orderListOutDTO.setCreateTimestamp(order.getCreateTime().getTime());
            return orderListOutDTO;
        }).collect(Collectors.toList());

        PageOutDTO<OrderListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setList(OrderListOutDTOS);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public OrderShowOutDTO getById(
            @RequestParam Long orderId
    ){
        OrderShowOutDTO orderShowOutDTO = orderService.getById(orderId);
        return orderShowOutDTO;
    }
}
