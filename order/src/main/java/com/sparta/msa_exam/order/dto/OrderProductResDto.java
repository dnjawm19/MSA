package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.entity.OrderProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderProductResDto {
    private Long id;
    private Long orderId;
    private String orderName;
    private Long product_id;

    public OrderProductResDto(OrderProduct orderProduct, Order order) {
        this.id = orderProduct.getId();
        this.product_id = orderProduct.getProduct_id();
        this.orderId = order.getId();
        this.orderName = order.getName();
    }
}
