package com.selemeneva.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("stock-app")
public interface StockClient {
    
    @GetMapping("/hello-world")
    String hello();
}
