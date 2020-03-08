package io.hbt.commerce.service;

import com.github.pagehelper.Page;
import io.hbt.commerce.po.Return;

public interface ReturnService {

    Page<Return> search(Integer pageNum);

    Return getById(Integer returnId);

}
