package com.ravi.orbit.service;

import com.ravi.orbit.dto.ProductDTO;
import com.ravi.orbit.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IProductService {

    ProductDTO handleProduct(ProductDTO productDTO);

    Page<ProductDTO> getAllProducts(Pageable pageable);

    ProductDTO getProduct(UUID id);

    ProductDTO getProductByCode(String code);

    Page<ProductDTO> getProductDTOsByName(Pageable pageable, String name);

    Page<ProductDTO> getProductDTOsByCategoryId(Pageable pageable, UUID categoryId);

    Page<ProductDTO> getProductDTOsBySellerId(Pageable pageable, UUID sellerId);

    void deleteProduct(UUID id);

    void deleteProductHard(UUID id);

    Product getProductById(UUID id);

}
