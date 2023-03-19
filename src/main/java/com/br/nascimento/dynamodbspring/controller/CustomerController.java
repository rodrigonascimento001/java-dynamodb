package com.br.nascimento.dynamodbspring.controller;

import com.br.nascimento.dynamodbspring.model.Customer;
import com.br.nascimento.dynamodbspring.service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") String customerId) {
        log.info("Rota findById iniciada ID: {}",customerId);
        return service.getById(customerId);
    }

    @GetMapping
    public List<Customer> findAll(){
        log.info("Rota para listar todos Customers iniciada");
        return  service.findAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") String customerId) {
        log.info("Rota para deletar pelo id iniciado ID: {}", customerId);
        return  service.deleteById(customerId);
    }

    @PutMapping("/{id}")
    public String updateCustomer(@PathVariable("id") String customerId, @RequestBody Customer customer) {
        return service.update(customerId,customer);
    }
}