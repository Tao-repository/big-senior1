package io.hbt.commerce.service.impl;

import io.hbt.commerce.dao.ReturnMapper;
import io.hbt.commerce.po.Return;
import io.hbt.commerce.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {

    @Autowired
    private ReturnMapper returnMapper;

    @Override
    public Integer create(Return ireturn) {
        returnMapper.insertSelective(ireturn);
        Integer returnId = ireturn.getReturnId();
        return returnId;
    }
}
