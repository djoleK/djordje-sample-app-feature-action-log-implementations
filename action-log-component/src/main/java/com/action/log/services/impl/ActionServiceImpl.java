package com.action.log.services.impl;

import com.action.log.mappers.ActionMapper;
import com.action.log.models.generated.Action;
import com.action.log.models.generated.ActionEvent;
import com.action.log.repositories.ActionRepository;
import com.action.log.services.ActionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;

    public ActionServiceImpl(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }

    @Override
    public List<ActionEvent> findAllActionEvents(String loggedInUserId, String customerId, Action action) {
        if (StringUtils.isEmpty(loggedInUserId) && StringUtils.isEmpty(customerId) && action == null) {

            return actionRepository.findAll().stream().map(ActionMapper::mapActionModelToActionEvent).collect(Collectors.toList());

        } else if (StringUtils.isEmpty(loggedInUserId) && StringUtils.isEmpty(customerId)) {

            return actionRepository.findAll().stream().filter(actionModel -> actionModel.getAction().toString().equals(action.getValue()))
                    .map(ActionMapper::mapActionModelToActionEvent)
                    .collect(Collectors.toList());
        } else if (StringUtils.isEmpty(loggedInUserId) && action == null) {

            return actionRepository.findAll().stream().filter(actionModel -> actionModel.getCustomerId().equals(customerId))
                    .map(ActionMapper::mapActionModelToActionEvent)
                    .collect(Collectors.toList());
        } else if (StringUtils.isEmpty(customerId) && action == null) {

            return actionRepository.findAll().stream().filter(actionModel -> actionModel.getLoggedInUserId().equals(loggedInUserId))
                    .map(ActionMapper::mapActionModelToActionEvent)
                    .collect(Collectors.toList());

        } else if (StringUtils.isEmpty(customerId)) {
            return actionRepository.findAll().stream().filter(actionModel -> actionModel.getLoggedInUserId().equals(loggedInUserId) && actionModel.getAction().toString().equals(action.getValue()))
                    .map(ActionMapper::mapActionModelToActionEvent)
                    .collect(Collectors.toList());
        } else if (action == null) {

            return actionRepository.findAll().stream().filter(actionModel -> actionModel.getLoggedInUserId().equals(loggedInUserId) && actionModel.getCustomerId().equals(customerId))
                    .map(ActionMapper::mapActionModelToActionEvent)
                    .collect(Collectors.toList());
        } else if (StringUtils.isEmpty(loggedInUserId)) {

            return actionRepository.findAll().stream().filter(actionModel -> actionModel.getCustomerId().equals(customerId) && actionModel.getAction().toString().equals(action.getValue()))
                    .map(ActionMapper::mapActionModelToActionEvent)
                    .collect(Collectors.toList());
        } else {

            return actionRepository.findAll().stream()
                    .filter(actionModel -> actionModel.getLoggedInUserId().equals(loggedInUserId) && actionModel.getCustomerId().equals(customerId) && actionModel.getAction().toString().equals(action.getValue()))
                    .map(ActionMapper::mapActionModelToActionEvent)
                    .collect(Collectors.toList());
        }

    }
}
