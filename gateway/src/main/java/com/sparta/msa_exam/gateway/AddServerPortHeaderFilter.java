package com.sparta.msa_exam.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;

@Component
public class AddServerPortHeaderFilter extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                URI uri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);
                if (uri != null) {
                    String port = String.valueOf(uri.getPort());
                    exchange.getResponse().getHeaders().add("Server-Port", port);
                }
            }));
        };
    }
}
