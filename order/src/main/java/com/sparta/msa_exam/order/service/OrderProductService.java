package com.sparta.msa_exam.order.service;

import com.sparta.msa_exam.order.client.Product;
import com.sparta.msa_exam.order.client.ProductClient;
import com.sparta.msa_exam.order.dto.OrderProductReqDto;
import com.sparta.msa_exam.order.dto.OrderProductResDto;
import com.sparta.msa_exam.order.entity.Order;
import com.sparta.msa_exam.order.entity.OrderProduct;
import com.sparta.msa_exam.order.repository.OrderProductRepository;
import com.sparta.msa_exam.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProductService {

    private final ProductClient productClient;

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    @CacheEvict(cacheNames = "orderProductListCache", allEntries = true)
    public OrderProductResDto addProduct(Long orderId, OrderProductReqDto orderProductReqDto) {
        Order order = existOrder(orderId);
        existProduct(orderProductReqDto.getProduct_id());

        OrderProduct orderProduct = orderProductRepository.save(new OrderProduct(order, orderProductReqDto));
        return new OrderProductResDto(orderProduct, order);
    }

    private Order existOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(
            () -> new IllegalArgumentException("해당 주문이 존재하지 않습니다.")
        );
    }

    private Product existProduct(Long productId) {
        return productClient.getProduct(productId);
    }
}
