package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.dto.OrderProductListResDto;
import com.sparta.msa_exam.order.dto.OrderReqDto;
import com.sparta.msa_exam.order.dto.OrderResDto;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;


    public OrderResDto create(OrderReqDto orderReqDto) {
        Order order = orderRepository.save(new Order(orderReqDto));
        return new OrderResDto(order);
    }

    public OrderProductListResDto getProductList(Long id) {
        Order order = existOrder(id);
        return new OrderProductListResDto(order);
    }

    private Order existOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(
            () -> new IllegalArgumentException("해당 주문이 존재하지 않습니다.")
        );
    }
}