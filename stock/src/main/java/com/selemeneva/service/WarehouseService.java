package com.selemeneva.service;

import com.selemeneva.model.ProductItem;
import com.selemeneva.model.Warehouse;
import liquibase.pro.packaged.L;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface WarehouseService {
    Warehouse findById(Long id); //поиск склада по id

    void createWarehouse(Warehouse warehouse);//создание склада в БД

    void updateWarehouse(Warehouse warehouse);//обновление склада в БД

    void deleteWarehouse(Long id);// удаление склада по Id из БД

    Set<Warehouse> getAllWarehouses();//получение списка складов

}
