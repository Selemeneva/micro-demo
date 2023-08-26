package com.selemeneva.service;

import com.selemeneva.model.ProductItem;

import java.util.Set;

public interface ProductItemService {
    ProductItem findById(Long id); //поиск карточки товара по id

    void createProductItem(ProductItem productItem);//создание новой карточки товара в БД

    void updateProductItem(ProductItem productItem);//обновление покупателя в БД

    void deleteProductItem(Long id);// удаление карточки товара по Id из БД

    Set<ProductItem> getAllProductItems();//получение списка покупателей

}
