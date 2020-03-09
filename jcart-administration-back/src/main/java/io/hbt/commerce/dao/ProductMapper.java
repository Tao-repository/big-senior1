package io.hbt.commerce.dao;

import com.github.pagehelper.Page;
import io.hbt.commerce.dto.out.ProductListOutDTO;
import io.hbt.commerce.po.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    Page<ProductListOutDTO> search();
}