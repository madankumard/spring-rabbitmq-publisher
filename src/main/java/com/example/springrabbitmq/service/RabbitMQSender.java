package com.example.springrabbitmq.service;

import com.example.springrabbitmq.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Value("${demo.rabbitmq.exchange}")
    private String exchange;

    @Value("${demo.rabbitmq.routingkey}")
    private String routingKey;

    public void send(Employee employee){
        rabbitTemplate.convertAndSend(exchange, routingKey, employee);
        System.out.println("Sent msg=" + employee);
    }

}
