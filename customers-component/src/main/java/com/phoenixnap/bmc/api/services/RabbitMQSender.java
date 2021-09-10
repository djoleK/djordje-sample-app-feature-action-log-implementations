package com.phoenixnap.bmc.api.services;

import com.phoenixnap.bmc.events.ActionEvent;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate template;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    public void send(ActionEvent actionEvent, String routingKey) {
        template.convertAndSend(exchange, routingKey, actionEvent);
        System.out.println("Send message = " + actionEvent);
    }
}
