package io.hbt.commerce.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.hbt.commerce.dao.ProductMapper;
import io.hbt.commerce.dao.ReturnMapper;
import io.hbt.commerce.dto.in.ProductSearchInDTO;
import io.hbt.commerce.dto.in.ReturnSearchInDTO;
import io.hbt.commerce.dto.out.ProductListOutDTO;
import io.hbt.commerce.po.Return;
import io.hbt.commerce.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ReturnServiceImpl implements ReturnService {
    @Autowired
    ReturnMapper returnMapper;

    @Autowired
    ProductMapper productMapper;

    @Override
    public Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum) {
        PageHelper.startPage(pageNum, 10);
        Page<Return> page = returnMapper
                .search(returnSearchInDTO.getReturnId(),
                        returnSearchInDTO.getOrderId(),
                        returnSearchInDTO.getStartTimestamp() == null ? null : new Date(returnSearchInDTO.getStartTimestamp()),
                        returnSearchInDTO.getEndTimestamp() == null ? null : new Date(returnSearchInDTO.getEndTimestamp()),
                        returnSearchInDTO.getStatus(),
                        returnSearchInDTO.getProductCode(),
                        returnSearchInDTO.getCustomerName(),
                        returnSearchInDTO.getProductName());
        return page;
    }

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

    @Override
    public void update(Return aReturn) {
        returnMapper.updateByPrimaryKeySelective(aReturn);
    }
}
