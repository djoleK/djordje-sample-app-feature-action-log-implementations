package com.action.log.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.inbound.AmqpInboundChannelAdapter;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.retry.support.RetryTemplate;

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

    @Bean
    public MessageChannel amqpInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public AmqpInboundChannelAdapter amqpInboundChannelAdapter(SimpleMessageListenerContainer container, @Qualifier("amqpInputChannel") MessageChannel messageChannel) {
        AmqpInboundChannelAdapter adapter = new AmqpInboundChannelAdapter(container);
        adapter.setOutputChannel(messageChannel);
        adapter.setMessageConverter(new Jackson2JsonMessageConverter());
        adapter.setRetryTemplate(new RetryTemplate());
        return adapter;
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(connectionFactory);
        container.setQueueNames("customersQueue");
        container.setErrorHandler(throwable -> new RuntimeException("blabla"));
        return container;
    }

    @Bean
    public IntegrationFlow inboundAdapterFlow(AmqpInboundChannelAdapter amqpInboundChannelAdapter) {
        return IntegrationFlows.from(amqpInboundChannelAdapter)
                .route(Message.class,
                        message -> message.getHeaders().get("amqp_receivedRoutingKey", String.class),
                        routerSpec -> {
                            routerSpec.channelMapping(KEY_CREATE, "CREATED")
                                    .channelMapping(KEY_UPDATE, "UPDATED")
                                    .channelMapping(KEY_DELETE, "DELETED");
                        })
                .get();
    }
}
