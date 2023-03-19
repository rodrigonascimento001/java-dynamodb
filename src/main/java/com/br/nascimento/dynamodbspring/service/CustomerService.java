package com.br.nascimento.dynamodbspring.service;

import com.br.nascimento.dynamodbspring.model.Customer;
import com.br.nascimento.dynamodbspring.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer save(Customer customer){
       log.info("Salvando Customer: {}", customer);
       return repository.saveCustomer(customer);
    }

    public Customer getById(String customerId) {
        log.info("Localizando customer por id: {}",customerId);
        return repository.getCustomerById(customerId);
    }

    public List<Customer> findAll() {
        log.info("Listando todos Customers cadastrados");
        return repository.findAll();
    }

    public String deleteById(String customerId) {
        log.info("Deletando por id: {} " , customerId);
        return repository.deleteCustomerById(customerId);
    }

    public String update(String customerId, Customer customer){
        log.info("Atualizando Customers {} pelo id {}", customer,customerId);
        return repository.updateCustomer(customerId,customer);
    }
}
