package io.hbt.commerce.controller;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.ReturnApplyInDTO;
import io.hbt.commerce.dto.out.PageOutDTO;
import io.hbt.commerce.dto.out.ReturnListOutDTO;
import io.hbt.commerce.dto.out.ReturnShowOutDTO;
import io.hbt.commerce.po.Return;
import io.hbt.commerce.po.ReturnHistory;
import io.hbt.commerce.service.ReturnHistoryService;
import io.hbt.commerce.service.ReturnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @Autowired
    ReturnService returnService;

    @Autowired
    private ReturnHistoryService returnHistoryService;

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
    public PageOutDTO<ReturnListOutDTO> getList(@RequestAttribute Integer customerId,
                                                @RequestParam(required = false,defaultValue = "1") Integer pageNum
    ){
        Page<Return> page = returnService.getPageByCustomerId(customerId, pageNum);
        List<ReturnListOutDTO> collect = page.stream().map(aReturn -> {
            ReturnListOutDTO returnListOutDTO = new ReturnListOutDTO();
            returnListOutDTO.setReturnId(aReturn.getReturnId());
            returnListOutDTO.setOrderId(aReturn.getOrderId());
            returnListOutDTO.setCustomerName(aReturn.getCustomerName());
            returnListOutDTO.setCustomerId(aReturn.getCustomerId());
            returnListOutDTO.setStatus(aReturn.getStatus());
            returnListOutDTO.setCreateTimestamp(aReturn.getCreateTime().getTime());
            return returnListOutDTO;

        }).collect(Collectors.toList());

        PageOutDTO<ReturnListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(collect);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ReturnShowOutDTO getById(@RequestParam Integer returnId){
        Return byId = returnService.getById(returnId);

        ReturnShowOutDTO returnShowOutDTO = new ReturnShowOutDTO();

        returnShowOutDTO.setReturnId(byId.getReturnId());
        returnShowOutDTO.setOrderId(byId.getOrderId());
        returnShowOutDTO.setOrderTimestamp(byId.getOrderTime().getTime());
        returnShowOutDTO.setCustomerName(byId.getCustomerName());
        returnShowOutDTO.setMobile(byId.getMobile());
        returnShowOutDTO.setEmail(byId.getEmail());
        returnShowOutDTO.setStatus(byId.getStatus());
        returnShowOutDTO.setAction(byId.getAction());
        returnShowOutDTO.setProductCode(byId.getProductCode());
        returnShowOutDTO.setProductName(byId.getProductName());
        returnShowOutDTO.setQuantity(byId.getQuantity());
        returnShowOutDTO.setReason(byId.getReason());
        returnShowOutDTO.setOpened(byId.getOpened());
        returnShowOutDTO.setCreateTimestamp(byId.getCreateTime().getTime());
        returnShowOutDTO.setUpdateTimestamp(byId.getUpdateTime().getTime());

        List<ReturnHistory> byReturnId = returnHistoryService.getByReturnId(returnId);

        return returnShowOutDTO;
    }

}
