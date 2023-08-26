package com.selemeneva.service;

import com.selemeneva.model.Customer;
import com.selemeneva.repositories.CustomerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService{
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ID покупателя " + id + " не найден"));
        return customer;
    }

    @Transactional
    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void updateCustomer(Customer customer) {
        Customer customerExisting = customerRepository.findById(customer.getId())
                .orElseThrow(() -> new NotFoundException("Покупатель с ID" +customer.getId() +"не найден"));
        customerRepository.save(customer);
    }

    @Transactional
    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Set<Customer> getAllCustomers() {
        return new HashSet<>(customerRepository.findAll());


    }
}
