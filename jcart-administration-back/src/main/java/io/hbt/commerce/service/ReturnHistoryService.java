package io.hbt.commerce.service;

import io.hbt.commerce.po.ReturnHistory;

import java.util.List;

public interface ReturnHistoryService {

    Long create(ReturnHistory returnHistory);

    List<ReturnHistory> getListByReturnId(Integer returnId);
}
