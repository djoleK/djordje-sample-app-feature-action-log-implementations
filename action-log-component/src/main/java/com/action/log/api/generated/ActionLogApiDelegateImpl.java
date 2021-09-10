package com.action.log.api.generated;

import com.action.log.models.generated.Action;
import com.action.log.models.generated.ActionEvent;
import com.action.log.services.ActionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ActionLogApiDelegateImpl implements ActionLogApiDelegate {

    private final ActionService actionService;

    public ActionLogApiDelegateImpl(ActionService actionService) {
        this.actionService = actionService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ActionLogApiDelegate.super.getRequest();
    }

    @Override
    public ResponseEntity<List<ActionEvent>> actionLogGet(String loggedInUserId, String customerId, Action action) {
        List<ActionEvent> actionEvents = new ArrayList<>();
        try {
            actionService.findAllActionEvents(loggedInUserId, customerId, action).stream().forEach(actionEvents::add);

            if (actionEvents.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(actionEvents, HttpStatus.OK);
    }
}
