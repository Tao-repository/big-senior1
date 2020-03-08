package io.hbt.commerce.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.hbt.commerce.dao.ReturnMapper;
import io.hbt.commerce.po.Return;
import io.hbt.commerce.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    ReturnMapper returnMapper;

    @Override
    public Page<Return> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<Return> search = returnMapper.search();
        return search;
    }

    @Override
    public Return getById(Integer returnId) {
        Return aReturn = returnMapper.selectByPrimaryKey(returnId);
        return aReturn;
    }
}
