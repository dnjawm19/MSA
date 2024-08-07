package com.sparta.msa_exam.order.dto;

import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.entity.OrderProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class OrderProductListResDto implements Serializable {
    private Long order_id;
    private List<Integer> product_ids = new ArrayList<>();

    public OrderProductListResDto(Order order) {
        this.order_id = order.getId();
        for (OrderProduct orderProduct : order.getProductIds()) {
            product_ids.add(Math.toIntExact(orderProduct.getProduct_id()));
        }
    }

}
