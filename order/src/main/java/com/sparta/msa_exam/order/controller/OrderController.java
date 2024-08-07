package com.sparta.msa_exam.order.controller;

import com.sparta.msa_exam.order.dto.OrderProductReqDto;
import com.sparta.msa_exam.order.dto.OrderProductResDto;
import com.sparta.msa_exam.order.dto.OrderReqDto;
import com.sparta.msa_exam.order.dto.OrderResDto;
import com.sparta.msa_exam.order.service.OrderProductService;
import com.sparta.msa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final OrderProductService orderProductService;

    @PostMapping
    public OrderResDto create(@RequestBody OrderReqDto orderReqDto) {
        return orderService.create(orderReqDto);
    }

    @PutMapping("/{orderId}")
    public OrderProductResDto addProduct(@PathVariable Long orderId, @RequestBody OrderProductReqDto orderProductReqDto) {
        return orderProductService.addProduct(orderId, orderProductReqDto);
    }
}