package io.hbt.commerce.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
@CrossOrigin
public class ImageController {

    @PostMapping("/upload")
    public String upload(
            @RequestParam MultipartFile image
    ){
        return null;
    }

}
