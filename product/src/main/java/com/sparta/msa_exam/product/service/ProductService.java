package com.sparta.msa_exam.product.service;

import com.sparta.msa_exam.product.dto.ProductReqDto;
import com.sparta.msa_exam.product.dto.ProductResDto;
import com.sparta.msa_exam.product.entity.Product;
import com.sparta.msa_exam.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductResDto create(ProductReqDto productReqDto) {
        Product product = productRepository.save(new Product(productReqDto));
        return new ProductResDto(product);
    }

    public List<ProductResDto> getList() {
        List<Product> productList = productRepository.findAll();
        List<ProductResDto> productResDtoList = new ArrayList<>();

        for (Product product : productList) {
            productResDtoList.add((new ProductResDto(product)));
        }

        return productResDtoList;
    }

    public ProductResDto getById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 상품이 존재하지 않습니다.")
        );

        return new ProductResDto(product);
    }
}
