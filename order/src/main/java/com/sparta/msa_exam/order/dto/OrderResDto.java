package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OrderResDto {
    private Long id;
    private String name;

    public OrderResDto(Order order) {
        this.id = order.getId();
        this.name = order.getName();
    }
}
