package io.hbt.commerce.controller;


import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.ProductCreateInDTO;
import io.hbt.commerce.dto.in.ProductSearchInDTO;
import io.hbt.commerce.dto.in.ProductUpdateInDTO;
import io.hbt.commerce.dto.out.PageOutDTO;
import io.hbt.commerce.dto.out.ProductListOutDTO;
import io.hbt.commerce.dto.out.ProductShowOutDTO;
import io.hbt.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public PageOutDTO<ProductListOutDTO> search(
            ProductSearchInDTO productSearchInDTO,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum
    ){
        Page<ProductListOutDTO> page = productService.search(pageNum);
        PageOutDTO<ProductListOutDTO> pageOutDTO = new PageOutDTO<>();
        pageOutDTO.setTotal(page.getTotal());
        pageOutDTO.setPageSize(page.getPageSize());
        pageOutDTO.setPageNum(page.getPageNum());
        pageOutDTO.setList(page);

        return pageOutDTO;
    }

    @GetMapping("/getById")
    public ProductShowOutDTO getById(
            @RequestParam Integer productId
    ){
        ProductShowOutDTO productShowOutDTO = productService.getById(productId);
        return productShowOutDTO;
    }

    @PostMapping("/create")
    public Integer create(
            @RequestBody ProductCreateInDTO productCreateInDTO
    ){
        Integer productId = productService.create(productCreateInDTO);
        return productId;
    }

    @PostMapping("/update")
    public void update(
            @RequestBody ProductUpdateInDTO productUpdateInDTO
    ){
        productService.update(productUpdateInDTO);
    }
}
