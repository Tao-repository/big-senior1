package io.hbt.commerce.service.impl;

import io.hbt.commerce.dao.ReturnHistoryMapper;
import io.hbt.commerce.po.Return;
import io.hbt.commerce.po.ReturnHistory;
import io.hbt.commerce.service.ReturnHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReturnHistoryServiceImpl implements ReturnHistoryService {
    @Autowired
    private ReturnHistoryMapper returnHistoryMapper;

    @Override
    public Long create(ReturnHistory returnHistory) {
        returnHistoryMapper.insertSelective(returnHistory);
        Long returnHistoryId = returnHistory.getReturnHistoryId();

        Return aReturn = new Return();
        aReturn.setReturnId(returnHistory.getReturnId());
        aReturn.setUpdateTime(new Date());
        return returnHistoryId;
    }
}
