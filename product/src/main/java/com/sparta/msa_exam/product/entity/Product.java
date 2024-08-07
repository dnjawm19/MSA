package com.sparta.msa_exam.product.entity;

import com.sparta.msa_exam.product.dto.ProductReqDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private int supply_price;

    public Product(ProductReqDto productReqDto){
        this.name = productReqDto.getName();
        this.supply_price = productReqDto.getSupply_price();
    }
}
