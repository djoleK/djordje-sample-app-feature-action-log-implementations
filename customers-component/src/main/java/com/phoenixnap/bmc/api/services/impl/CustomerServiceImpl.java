package com.phoenixnap.bmc.api.services.impl;

import com.phoenixnap.bmc.api.mappers.CustomerMapper;
import com.phoenixnap.bmc.api.models.Customer;
import com.phoenixnap.bmc.api.repositories.CustomerRepository;
import com.phoenixnap.bmc.api.repositories.models.CustomerModel;
import com.phoenixnap.bmc.api.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::mapCustomerModelToCustomer).collect(Collectors.toList());
    }

    @Override
    public Optional<Customer> getCustomerById(String id) {
        CustomerModel customerModel = customerRepository.findById(id).get();
        return Optional.of(CustomerMapper.mapCustomerModelToCustomer(customerModel));
    }

    @Override
    public Customer save(CustomerModel customerModel) {
        customerRepository.save(customerModel);
        return CustomerMapper.mapCustomerModelToCustomer(customerModel);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.delete(customerRepository.findById(id).get());
    }

}
