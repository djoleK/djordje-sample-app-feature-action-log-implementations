package com.phoenixnap.bmc.api.repositories;

import com.phoenixnap.bmc.api.repositories.models.CustomerModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<CustomerModel, String> {

}
