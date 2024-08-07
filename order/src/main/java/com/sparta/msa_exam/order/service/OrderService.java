package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.dto.OrderReqDto;
import com.sparta.msa_exam.order.dto.OrderResDto;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;
    private final OrderRepository orderRepository;


    public OrderResDto create(OrderReqDto orderReqDto) {
        Order order = orderRepository.save(new Order(orderReqDto));
        return new OrderResDto(order);
    }
}