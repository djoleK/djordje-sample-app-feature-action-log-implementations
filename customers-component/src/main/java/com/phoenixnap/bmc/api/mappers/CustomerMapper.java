package com.phoenixnap.bmc.api.mappers;

import com.phoenixnap.bmc.api.models.Customer;
import com.phoenixnap.bmc.api.repositories.models.CustomerModel;
import com.phoenixnap.bmc.pojos.CustomerEntity;

public class CustomerMapper {

    private CustomerMapper() {
    }

    public static Customer mapCustomerModelToCustomer(CustomerModel customerModel) {
        final Customer customer = new Customer();
        customer.setId(customerModel.getId());
        customer.setFirstName(customerModel.getFirstName());
        customer.setLastName(customerModel.getLastName());
        return customer;
    }

    public static CustomerEntity mapCustomerModelToCustomerEntity(CustomerModel customerModel) {
        final CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setFirstName(customerModel.getFirstName());
        customerEntity.setLastName(customerModel.getLastName());
        customerEntity.setId(customerModel.getId());
        return customerEntity;
    }

    public static CustomerEntity mapCustomerToCustomerEntity(Customer customer) {
        final CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customer.getId());
        customerEntity.setLastName(customer.getLastName());
        customerEntity.setFirstName(customer.getFirstName());
        return customerEntity;
    }
}
