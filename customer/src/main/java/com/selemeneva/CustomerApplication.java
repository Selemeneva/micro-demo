package com.selemeneva;


import com.selemeneva.client.StockClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CustomerApplication {
    public static void main(String[] args) {
        var stockClient = SpringApplication.run(CustomerApplication.class, args).getBean(StockClient.class);

        System.out.println(stockClient.hello());
    }
}
