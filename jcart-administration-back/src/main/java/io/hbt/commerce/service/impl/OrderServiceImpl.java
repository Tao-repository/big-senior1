package io.hbt.commerce.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.hbt.commerce.dao.OrderMapper;
import io.hbt.commerce.dto.in.OrderSearchInDTO;
import io.hbt.commerce.dto.out.OrderListOutDTO;
import io.hbt.commerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Page<OrderListOutDTO> search(OrderSearchInDTO orderSearchInDTO, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<OrderListOutDTO> page = orderMapper
                .search(orderSearchInDTO.getOrderId(),
                        orderSearchInDTO.getStatus(),
                        orderSearchInDTO.getTotalPrice(),
                        orderSearchInDTO.getCustomerName(),
                        orderSearchInDTO.getStartTimestamp() == null ? null : new Date(orderSearchInDTO.getStartTimestamp()),
                        orderSearchInDTO.getEndTimestamp() == null ? null : new Date(orderSearchInDTO.getEndTimestamp()));
        return page;
    }

}
