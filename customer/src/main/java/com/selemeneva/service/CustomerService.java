package com.selemeneva.service;

import com.selemeneva.model.Customer;
import org.springframework.stereotype.Service;

import java.util.Set;

public interface CustomerService {
    Customer findById(Long id); //поиск покупателя по id

    void createCustomer(Customer customer);//создание нового покупателя в БД

    void updateCustomer(Customer customer);//обновление покупателя в БД

    void deleteCustomerById(Long id);// удаление покупателя по Id из БД

    Set<Customer> getAllCustomers();//получение списка покупателей

}
