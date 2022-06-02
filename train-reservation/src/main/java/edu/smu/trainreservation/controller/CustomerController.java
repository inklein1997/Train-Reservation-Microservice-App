package edu.smu.trainreservation.controller;

import edu.smu.trainreservation.dto.Customer;
import edu.smu.trainreservation.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
public class CustomerController {

    @Autowired
    ServiceLayer serviceLayer;

    @GetMapping("/customers")
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomers() {
        return serviceLayer.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Customer> getCustomerById(@PathVariable Integer id) {
        return serviceLayer.getCustomerById(id);
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        return serviceLayer.createCustomer(customer);
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) {
        if (id.equals(customer.getCustomerId())) {
            serviceLayer.updateCustomer(customer);
        }
        if (customer.getCustomerId().equals(null)) {
            customer.setCustomerId(id);
            serviceLayer.updateCustomer(customer);
        }
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id) {
        serviceLayer.deleteCustomer(id);
    }

}
