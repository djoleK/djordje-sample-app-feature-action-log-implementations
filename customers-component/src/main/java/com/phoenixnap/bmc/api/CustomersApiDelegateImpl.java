package com.phoenixnap.bmc.api;

import com.phoenixnap.bmc.api.mappers.CustomerMapper;
import com.phoenixnap.bmc.api.models.Customer;
import com.phoenixnap.bmc.api.repositories.models.CustomerModel;
import com.phoenixnap.bmc.api.services.CustomerService;
import com.phoenixnap.bmc.api.services.RabbitMQSender;
import com.phoenixnap.bmc.events.ActionEvent;
import com.phoenixnap.bmc.pojos.Action;
import com.phoenixnap.bmc.pojos.UserEntity;
import org.keycloak.KeycloakPrincipal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import static com.phoenixnap.bmc.constants.Constants.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomersApiDelegateImpl implements CustomersApiDelegate {

    private final CustomerService customerService;
    private final RabbitMQSender rabbitMQSender;

    public CustomersApiDelegateImpl(CustomerService customerService, RabbitMQSender rabbitMQSender) {
        this.customerService = customerService;
        this.rabbitMQSender = rabbitMQSender;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return CustomersApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<Customer> createCustomer(Customer customer) {
        KeycloakPrincipal token = (KeycloakPrincipal) SecurityContextHolder.getContext().getAuthentication();

        try {
            CustomerModel newCustomer = new CustomerModel();
            newCustomer.setFirstName(customer.getFirstName());
            newCustomer.setLastName(customer.getLastName());
            customerService.save(newCustomer);
            rabbitMQSender.send(new ActionEvent(CustomerMapper.mapCustomerModelToCustomerEntity(newCustomer),
                    new UserEntity("1", "Djole"), Action.CREATED), KEY_CREATE);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Void> deleteCustomer(String id) {
        try {
            rabbitMQSender.send(new ActionEvent(CustomerMapper.mapCustomerToCustomerEntity(customerService.getCustomerById(id).get()),
                    new UserEntity("1", "Djole"), Action.DELETED), KEY_DELETE);
            customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {
        try {
            List<Customer> customers = new ArrayList<>();
            customerService.findAllCustomers().forEach(customers::add);
            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(String id) {
        Optional<Customer> optionalCustomer = customerService.getCustomerById(id);
        if (optionalCustomer.isPresent()) {
            return new ResponseEntity<>(optionalCustomer.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Customer> updateCustomer(String id, Customer customer) {
        Optional<Customer> customerData = customerService.getCustomerById(id);
        if (customerData.isPresent()) {
            CustomerModel updatedCustomer = new CustomerModel();
            updatedCustomer.setId(customer.getId());
            updatedCustomer.setFirstName(customer.getFirstName());
            updatedCustomer.setLastName(customer.getLastName());
            rabbitMQSender.send(new ActionEvent(CustomerMapper.mapCustomerModelToCustomerEntity(updatedCustomer),
                    new UserEntity("1", "Djole"), Action.UPDATED), KEY_UPDATE);
            return new ResponseEntity<>(customerService.save(updatedCustomer), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
