package io.hbt.commerce.service;


import com.github.pagehelper.Page;
import io.hbt.commerce.dto.in.ProductCreateInDTO;
import io.hbt.commerce.dto.in.ProductUpdateInDTO;
import io.hbt.commerce.dto.out.ProductListOutDTO;
import io.hbt.commerce.dto.out.ProductShowOutDTO;

public interface ProductService {

    Integer create(ProductCreateInDTO productCreateInDTO);

    Page<ProductListOutDTO> search(Integer pageNum);

    void update(ProductUpdateInDTO productUpdateInDTO);

    ProductShowOutDTO getById(Integer productId);
}
