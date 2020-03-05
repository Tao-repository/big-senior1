package io.hbt.commerce.controller;

import io.hbt.commerce.dto.in.ReturnApplyInDTO;
import io.hbt.commerce.dto.out.PageOutDTO;
import io.hbt.commerce.dto.out.ReturnListOutDTO;
import io.hbt.commerce.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @PostMapping("/apply")
    public Integer apply(
            @RequestBody ReturnApplyInDTO returnApplyInDTO,
            @RequestAttribute Integer customerId
    ){
        return null;
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
