package io.hbt.commerce.service;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.ReturnSearchInDTO;
import io.hbt.commerce.po.Return;

public interface ReturnService {

    Page<Return> search(ReturnSearchInDTO returnSearchInDTO, Integer pageNum);

    Page<Return> search(Integer pageNum);

    Return getById(Integer returnId);

    void update(Return aReturn);
}
