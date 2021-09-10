package com.action.log.services;

import com.action.log.models.generated.Action;
import com.action.log.models.generated.ActionEvent;

import java.util.List;


public interface ActionService {
    List<ActionEvent> findAllActionEvents(String loggedInUserId, String customerId, Action action);
}
