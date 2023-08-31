package com.example.springrabbitmq.controller;

import com.example.springrabbitmq.model.Employee;
import com.example.springrabbitmq.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQWebController {

    @Autowired
    private RabbitMQSender sender;

    @GetMapping("/producer")
    public String producer(@RequestParam("empName") String empName, @RequestParam("empId") String empId){

        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        sender.send(emp);

        return "Message sent to rabbit mq successfully";
    }
}
