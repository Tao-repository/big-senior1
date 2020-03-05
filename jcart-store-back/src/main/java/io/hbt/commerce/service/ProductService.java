package io.hbt.commerce.service;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.out.ProductListOutDTO;
import io.hbt.commerce.dto.out.ProductShowOutDTO;
import io.hbt.commerce.po.Product;

public interface ProductService {
    Page<ProductListOutDTO> search(Integer pageNum);

    Product getById(Integer productId);

    ProductShowOutDTO getShowById(Integer productId);
}
