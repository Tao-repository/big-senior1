package io.hbt.commerce.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.hbt.commerce.dao.ProductDetailMapper;
import io.hbt.commerce.dao.ProductMapper;
import io.hbt.commerce.dto.out.ProductListOutDTO;
import io.hbt.commerce.dto.out.ProductShowOutDTO;
import io.hbt.commerce.po.Product;
import io.hbt.commerce.po.ProductDetail;
import io.hbt.commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductDetailMapper productDetailMapper;


    @Override
    public Page<ProductListOutDTO> search(Integer pageNum) {
        PageHelper.startPage(pageNum,10);
        Page<ProductListOutDTO> productListOutDTOS = productMapper.search();
        return productListOutDTOS;
    }

    @Override
    public Product getById(Integer productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }

    @Override
    public ProductShowOutDTO getShowById(Integer productId) {

        Product product = productMapper.selectByPrimaryKey(productId);
        ProductDetail productDetail = productDetailMapper.selectByPrimaryKey(productId);

        ProductShowOutDTO productShowOutDTO = new ProductShowOutDTO();
        productShowOutDTO.setProductId(product.getProductId());
        productShowOutDTO.setProductCode(product.getProductCode());
        productShowOutDTO.setProductName(product.getProductName());
        productShowOutDTO.setPrice(product.getPrice());
        productShowOutDTO.setDiscount(product.getDiscount());
        productShowOutDTO.setMainPicUrl(product.getMainPicUrl());
        productShowOutDTO.setRewordPoints(product.getRewordPoints());
        productShowOutDTO.setStockQuantity(product.getStockQuantity());

        productShowOutDTO.setDescription(productDetail.getDescription());
        String otherPicUrlsJson = productDetail.getOtherPicUrls();
        List<String> otherPicUrls = JSON.parseArray(otherPicUrlsJson, String.class);
        productShowOutDTO.setOtherPicUrls(otherPicUrls);

        return productShowOutDTO;
    }
}
