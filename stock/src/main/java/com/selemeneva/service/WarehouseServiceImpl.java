package com.selemeneva.service;

import com.selemeneva.model.Warehouse;
import com.selemeneva.repositories.WarehouseRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.HashSet;
import java.util.Set;

@Service
public class WarehouseServiceImpl implements WarehouseService{
    
    @Autowired(required = false)
    private WarehouseRepository warehouseRepository;

    @Override
    public Warehouse findById(Long id) {
        Warehouse warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID склада " + id + " не найден"));
        return warehouse;
    }

    @Transactional
    @Override
    public void createWarehouse(Warehouse warehouse) {
        warehouseRepository.save(warehouse);
    }

    @Transactional
    @Override
    public void updateWarehouse(Warehouse warehouse) {
        Warehouse warehouseExisting = warehouseRepository.findById(warehouse.getId())
                .orElseThrow(() -> new NotFoundException("Склад с ID" +warehouse.getId() +"не найден"));
        warehouseRepository.save(warehouse);
    }

    @Transactional
    @Override
    public void deleteWarehouse(Long id) {
        warehouseRepository.deleteById(id);
    }

    @Override
    public Set<Warehouse> getAllWarehouses() {
        return new HashSet<>(warehouseRepository.findAll());


    }
}
