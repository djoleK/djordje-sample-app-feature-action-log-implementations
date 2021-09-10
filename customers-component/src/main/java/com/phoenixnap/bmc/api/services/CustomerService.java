package com.phoenixnap.bmc.api.services;

import com.phoenixnap.bmc.api.models.Customer;
import com.phoenixnap.bmc.api.repositories.models.CustomerModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    List<Customer> findAllCustomers();

    Optional<Customer> getCustomerById(String id);

    Customer save(CustomerModel customerModel);

    void deleteCustomer(String id);

}
