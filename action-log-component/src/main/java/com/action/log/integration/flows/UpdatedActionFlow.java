package com.action.log.integration.flows;

import com.action.log.models.ActionEnum;
import com.action.log.models.ActionModel;
import com.action.log.repositories.ActionRepository;
import com.phoenixnap.bmc.events.ActionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.common.LiteralExpression;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.stereotype.Component;

@Component
public class UpdatedActionFlow {

    @Autowired
    private ActionRepository actionRepository;

    @Bean
    public IntegrationFlow updatedFlow() {
        return IntegrationFlows.from("UPDATED")
                .log(LoggingHandler.Level.INFO, new LiteralExpression("Starting UPDATE Flow..."))
                .<ActionEvent, ActionModel>transform(actionEvent -> new ActionModel(null, actionEvent.getCustomerEntity().getId(),
                        actionEvent.getLoggedInUser().getUserId(), ActionEnum.UPDATED))
                .<ActionModel>handle((action, messageHeaders) -> this.actionRepository.save(action))
                .log(LoggingHandler.Level.INFO, new LiteralExpression("Completed UPDATE Flow..."))
                .nullChannel();
    }
}
