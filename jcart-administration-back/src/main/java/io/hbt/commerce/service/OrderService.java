package io.hbt.commerce.service;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.OrderSearchInDTO;
import io.hbt.commerce.dto.out.OrderListOutDTO;
import io.hbt.commerce.dto.out.OrderShowOutDTO;

public interface OrderService {

    Page<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO, Integer pageNum);

    OrderShowOutDTO getById(Long orderId);

}
