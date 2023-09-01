package com.selemeneva.service;

import com.selemeneva.model.ProductItem;
import com.selemeneva.repositories.ProductItemRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductItemServiceImpl implements ProductItemService{
    
    @Autowired(required = false)
    private ProductItemRepository productItemRepository;

    @Override
    public ProductItem findById(Long id) {
        ProductItem productItem = productItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID товара " + id + " не найден"));
        return productItem;
    }

    @Transactional
    @Override
    public void createProductItem(ProductItem productItem) {
        productItemRepository.save(productItem);
    }

    @Transactional
    @Override
    public void updateProductItem(ProductItem productItem) {
        ProductItem productItemExisting = productItemRepository.findById(productItem.getId())
                .orElseThrow(() -> new NotFoundException("Товар с ID" +productItem.getId() +"не найден"));
        productItemRepository.save(productItem);
    }

    @Transactional
    @Override
    public void deleteProductItem(Long id) {
        productItemRepository.deleteById(id);
    }

    @Override
    public Set<ProductItem> getAllProductItems() {
        return new HashSet<>(productItemRepository.findAll());


    }
}
