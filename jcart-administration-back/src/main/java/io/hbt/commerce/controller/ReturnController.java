package io.hbt.commerce.controller;

import io.hbt.commerce.dto.in.ReturnSearchInDTO;
import io.hbt.commerce.dto.in.ReturnUpdateActionInDTO;
import io.hbt.commerce.dto.out.PageOutDTO;
import io.hbt.commerce.dto.out.ReturnListOutDTO;
import io.hbt.commerce.dto.out.ReturnShowOutDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnController {

    @GetMapping("/search")
    public PageOutDTO<ReturnListOutDTO> search(
            ReturnSearchInDTO returnSearchInDTO,
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

    @PostMapping("/updateAction")
    public void updateAction(
            @RequestBody ReturnUpdateActionInDTO returnUpdateActionInDTO
    ){

    }
}
