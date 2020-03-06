package io.hbt.commerce.service;

import com.github.pagehelper.Page;
import io.hbt.commerce.po.Return;

public interface ReturnService {

    Integer create (Return ireturn);

    Page<Return> getPageByCustomerId(Integer customerId,Integer pageNum);

}
