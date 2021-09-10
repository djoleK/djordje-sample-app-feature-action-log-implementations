package com.phoenixnap.bmc.api.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.phoenixnap.bmc.constants.Constants.*;


@Configuration
public class RabbitConfig {

    @Value("${rabbitmq.exchange}")
    String exchange;

    @Bean(name = "customersQueue")
    Queue customersQueue() {
        return new Queue("customersQueue", false);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    Binding createBinding(@Qualifier("customersQueue") Queue customersQueue, DirectExchange exchange) {
        return BindingBuilder.bind(customersQueue).to(exchange).with(KEY_CREATE);
    }

    @Bean
    Binding updateBinding(@Qualifier("customersQueue") Queue customersQueue, DirectExchange exchange) {
        return BindingBuilder.bind(customersQueue).to(exchange).with(KEY_UPDATE);
    }

    @Bean
    Binding deleteBinding(@Qualifier("customersQueue") Queue customersQueue, DirectExchange exchange) {
        return BindingBuilder.bind(customersQueue).to(exchange).with(KEY_DELETE);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }

}
