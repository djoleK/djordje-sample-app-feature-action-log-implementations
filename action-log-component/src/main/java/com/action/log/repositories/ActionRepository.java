package com.action.log.repositories;

import com.action.log.models.ActionModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActionRepository extends MongoRepository<ActionModel, String> {
}
