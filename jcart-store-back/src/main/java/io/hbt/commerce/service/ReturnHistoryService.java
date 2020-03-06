package io.hbt.commerce.service;

import io.hbt.commerce.po.ReturnHistory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReturnHistoryService {

    List<ReturnHistory> getByReturnId(Integer returnId);

}
