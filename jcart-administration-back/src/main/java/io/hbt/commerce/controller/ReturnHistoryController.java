package io.hbt.commerce.controller;

import io.hbt.commerce.dto.in.ReturnHistoryCreateInDTO;
import io.hbt.commerce.dto.out.ReturnHistoryListOutDTO;
import io.hbt.commerce.po.ReturnHistory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/returnhistory")
@CrossOrigin
public class ReturnHistoryController {

    @GetMapping("/getListByReturnId")
    public List<ReturnHistoryListOutDTO> getListByReturnId(
            @RequestParam Integer returnId
    ){
        return null;
    }

    @PostMapping("/create")
    public Integer create(@RequestBody ReturnHistoryCreateInDTO returnHistoryCreateInDTO){
        ReturnHistory returnHistory = new ReturnHistory();
        returnHistory.setReturnId(returnHistoryCreateInDTO.getReturnId());
        returnHistory.setTime(new Date());
        returnHistory.setReturnStatus(returnHistoryCreateInDTO.getReturnStatus());
        returnHistory.setComment(returnHistoryCreateInDTO.getComment());
        Boolean customerNotifeid = returnHistoryCreateInDTO.getCustomerNotifeid();
        returnHistory.setCustomerNotified(customerNotifeid);

        if(customerNotifeid!=null && customerNotifeid){
            //todo send email to customer
        }

        return null;
    }
}
