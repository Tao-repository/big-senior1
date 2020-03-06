package io.hbt.commerce.controller;

import io.hbt.commerce.dto.in.ReturnApplyInDTO;
import io.hbt.commerce.dto.out.PageOutDTO;
import io.hbt.commerce.dto.out.ReturnListOutDTO;
import io.hbt.commerce.dto.out.ReturnShowOutDTO;
import io.hbt.commerce.po.Return;
import io.hbt.commerce.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    ReturnService returnService;

    @PostMapping("/apply")
    public Integer apply(
            @RequestBody ReturnApplyInDTO returnApplyInDTO,
            @RequestAttribute Integer customerId
    ){
        Return aReturn = new Return();
        aReturn.setOrderId(returnApplyInDTO.getOrderId());
        aReturn.setOrderTime(new Date(returnApplyInDTO.getOrderTimestamp()));
        aReturn.setCustomerId(customerId);
        aReturn.setCustomerName(returnApplyInDTO.getCustomerName());
        aReturn.setMobile(returnApplyInDTO.getMobile());
        aReturn.setEmail(returnApplyInDTO.getEmail());
        aReturn.setReason(returnApplyInDTO.getReason());
        aReturn.setOpened(returnApplyInDTO.getOpened());
        aReturn.setComment(returnApplyInDTO.getComment());
        Date now = new Date();
        aReturn.setCreateTime(now);
        aReturn.setUpdateTime(now);
        Integer integer = returnService.create(aReturn);

        return integer;
    }

    @GetMapping("/getList")
    public PageOutDTO<ReturnListOutDTO> getList(
            @RequestAttribute Integer customerId,
            @RequestParam Integer pageNum
    ){
        return null;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(
            @RequestParam Integer returnId
    ){
        return null;
    }

}
