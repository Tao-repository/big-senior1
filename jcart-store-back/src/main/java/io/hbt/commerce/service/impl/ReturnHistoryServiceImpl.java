package io.hbt.commerce.service.impl;

import io.hbt.commerce.dao.ReturnHistoryMapper;
import io.hbt.commerce.po.ReturnHistory;
import io.hbt.commerce.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReturnHistoryServiceImpl implements ReturnHistoryService {

    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Override
    public List<ReturnHistory> getByReturnId(Integer returnId) {
        List<ReturnHistory> returnHistories = returnHistoryMapper.selectByReturnId(returnId);
        return returnHistories;
    }
}
