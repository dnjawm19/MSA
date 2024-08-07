package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductReqDto;
import com.sparta.msa_exam.product.dto.ProductResDto;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResDto create(ProductReqDto productReqDto) {
        Product product = productRepository.save(new Product(productReqDto));
        return new ProductResDto(product);
    }
}
