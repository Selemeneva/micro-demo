package com.selemeneva.controllers;


import com.selemeneva.model.Warehouse;
import com.selemeneva.service.WarehouseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "Склад", description = "действия со складом")
@RequestMapping("/stock/warehouse")
public class WarehouseController {
    protected final WarehouseService warehouseService;
    private static Logger logger = LoggerFactory.getLogger(WarehouseController.class);

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }
    @GetMapping()
    @Operation(summary = "Получение всех складов",
            description = "Получение всех складов")
    public ResponseEntity<Set<Warehouse>> getWarehouseList() {
        logger.info("Запрос списка складов");
        Set<Warehouse> warehouseSet = warehouseService.getAllWarehouses();
        return ResponseEntity.ok(warehouseSet);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение склада по id",
            description = "Получение склада по id")
    public ResponseEntity<Warehouse> getWarehouseById(@PathVariable Long id) {
        logger.info("Запрос склада с id: " + id);
        return ResponseEntity.ok(warehouseService.findById(id));
    }

    @PostMapping()
    @Operation(summary = "Создание нового склада",
            description = "Создание нового склада")
    public ResponseEntity<Warehouse> createWarehouse(@RequestBody Warehouse warehouse) {
        logger.info("Запрос на создание нового склада");
        warehouseService.createWarehouse(warehouse);
        return ResponseEntity.ok(warehouse);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление склада", description = "Обновление склада")
    public ResponseEntity<Warehouse> updateWarehouse(@RequestBody Warehouse warehouse, @PathVariable Long id) {
        logger.info("Запрос на обновление склада");
        warehouseService.updateWarehouse(warehouse);
        return ResponseEntity.ok(warehouse);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление склада по id", description = "Удаление склада по id")
    public ResponseEntity<HttpStatus> deleteWarehouse(@PathVariable Long id) {
        logger.info("Запрос на удаление склада с id: " + id);
        warehouseService.deleteWarehouse(id);
        return ResponseEntity.ok().build();
    }
}
