package com.sparta.msa_exam.order.entity;

import com.sparta.msa_exam.order.dto.OrderProductReqDto;
import com.sparta.msa_exam.order.dto.OrderReqDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Column
    private Long product_id;

    public OrderProduct(Order order, OrderProductReqDto orderProductReqDto){
        this.order = order;
        this.product_id = orderProductReqDto.getProduct_id();
    }
}
