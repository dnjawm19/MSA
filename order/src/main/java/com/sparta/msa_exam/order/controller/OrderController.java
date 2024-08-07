package com.sparta.msa_exam.order.controller;

import com.sparta.msa_exam.order.dto.OrderReqDto;
import com.sparta.msa_exam.order.dto.OrderResDto;
import com.sparta.msa_exam.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public OrderResDto create(@RequestBody OrderReqDto orderReqDto) {
        return orderService.create(orderReqDto);
    }
}