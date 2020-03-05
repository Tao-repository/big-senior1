package io.hbt.commerce.service;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.OrderCheckoutInDTO;
import io.hbt.commerce.dto.out.OrderShowOutDTO;
import io.hbt.commerce.po.Order;

public interface OrderService {
    Long checkout(OrderCheckoutInDTO orderCheckoutInDTO, Integer customerId);

    Page<Order> getByCustomerId(Integer pageNum, Integer customerId);

    OrderShowOutDTO getById(Long orderId);
}
