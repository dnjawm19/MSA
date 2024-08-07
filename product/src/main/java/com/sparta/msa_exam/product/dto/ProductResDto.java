package com.sparta.msa_exam.product.dto;

import com.sparta.msa_exam.product.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResDto {
    private Long id;
    private String name;
    private int supply_price;

    public ProductResDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.supply_price = product.getSupply_price();
    }
}
