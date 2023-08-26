package com.selemeneva.controllers;

import com.selemeneva.model.ProductItem;
import com.selemeneva.service.ProductItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@Tag(name = "Карточка товара", description = "действия с карточкой товара")
@RequestMapping("/stock/product_item")
public class ProductItemController {
    private final ProductItemService productItemService;

    public ProductItemController(ProductItemService productItemService) {
        this.productItemService = productItemService;
    }
    private static final Logger logger = LoggerFactory.getLogger(ProductItemController.class);


    @GetMapping()
    @Operation(summary = "Получение всех товаров",
            description = "Получение всех товаров")
    public ResponseEntity<Set<ProductItem>> getProductItemList() {
        logger.info("Запрос списка товаров");
        Set<ProductItem> productItemSet = productItemService.getAllProductItems();
        return ResponseEntity.ok(productItemSet);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение товара по id",
            description = "Получение товара по id")
    public ResponseEntity<ProductItem> getProductItemById(@PathVariable Long id) {
        logger.info("Запрос товара по id: " + id);
        return ResponseEntity.ok(productItemService.findById(id));
    }

    @PostMapping()
    @Operation(summary = "Создание новой карточки товара",
            description = "Создание новой карточки товара")
    public ResponseEntity<ProductItem> createProductItem(@RequestBody ProductItem productItem) {
        logger.info("Запрос на создание новой карточки товара");
        productItemService.createProductItem(productItem);
        return ResponseEntity.ok(productItem);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Обновление карточки товара", description = "Обновление карточки товара")
    public ResponseEntity<ProductItem> updateProductItem(@RequestBody ProductItem productItem, @PathVariable Long id) {
        logger.info("Запрос на обновление карточки товара");
        productItemService.updateProductItem(productItem);
        return ResponseEntity.ok(productItem);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Удаление товара по id", description = "Удаление товара по id")
    public ResponseEntity<HttpStatus> deleteProductItem(@PathVariable Long id) {
        logger.info("Запрос на удаление товара с id: " + id);
        productItemService.deleteProductItem(id);
        return ResponseEntity.ok().build();
    }


}
