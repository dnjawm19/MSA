package com.sparta.msa_exam.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final ProductClient productClient;

    public String getProductInfo(String productId) {
        return productClient.getProduct(productId);
    }

    public String getOrder(String orderId) {
        if (orderId.equals("1")) {
            String productId = "2";
            String productInfo = getProductInfo(productId);
            return "Your orderId is " + orderId + " productInfo is " + productInfo;
        }
        return "Not exist order...";
    }
}