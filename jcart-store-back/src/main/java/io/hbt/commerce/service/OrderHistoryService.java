package io.hbt.commerce.service;

import io.hbt.commerce.po.OrderHistory;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistory> getByOrderId(Long orderId);
}
