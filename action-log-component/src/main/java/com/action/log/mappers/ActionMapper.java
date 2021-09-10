package com.action.log.mappers;

import com.action.log.models.ActionModel;
import com.action.log.models.generated.ActionEvent;

public class ActionMapper {

    private ActionMapper() {
    }

    public static ActionEvent mapActionModelToActionEvent(ActionModel actionModel) {
        ActionEvent actionEvent = new ActionEvent();
        actionEvent.setLoggedInUserId(actionModel.getLoggedInUserId());
        actionEvent.setCustomerId(actionModel.getCustomerId());
        actionEvent.setAction(actionModel.getAction().toString());
        actionEvent.setId(actionModel.getId());
        return actionEvent;
    }
}
