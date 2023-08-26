package com.selemeneva.controllers;

import com.selemeneva.model.Customer;
import com.selemeneva.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "Покупатель", description = "действия с покупателями")
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customService) {
        this.customerService = customService;
    }

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @GetMapping()
    @Operation(summary = "Получение всех покупателей",
            description = "Получение всех покупателей")
    public ResponseEntity<Set<Customer>> getCustomerList() {
        logger.info("Запрос списка покупателей");
        Set<Customer> customerSet = customerService.getAllCustomers();
        return ResponseEntity.ok(customerSet);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Получение покупателя по id",
            description = "Получение покупателя по id")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        logger.info("Запрос покупателя по id: " + id);
        return ResponseEntity.ok(customerService.findById(id));
    }

    @PostMapping()
    @Operation(summary = "Создание нового покупателя",
            description = "Создание нового покупателя")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        logger.info("Запрос на создание нового покупателя");
        customerService.createCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление покупателя", description = "Обновление покупателя")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        logger.info("Запрос на обновление покупателя");
        customerService.updateCustomer(customer);
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление покупателя по id", description = "Удаление покупателя по id")
    public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable Long id) {
        logger.info("Запрос на удаление покупателя с id: " + id);
        customerService.deleteCustomerById(id);
        return ResponseEntity.ok().build();
    }



}
