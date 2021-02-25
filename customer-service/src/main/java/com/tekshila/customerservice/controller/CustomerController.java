package com.tekshila.customerservice.controller;

import com.tekshila.customerservice.domain.Customer;
import com.tekshila.customerservice.domain.Trip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/tekshila/api/v1/customers")
public class CustomerController {

    List<Customer> customers = Arrays.asList(
        new Customer(1, "name1", "email1@tekshila.com"),
        new Customer(2, "name2", "email2@tekshila.com"),
        new Customer(3, "name3", "email3@tekshila.com")
    );

    private RestTemplate restTemplate;

    @Autowired
    public CustomerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public List<Customer> listCustomers() {
        return customers;
    }

    @GetMapping(path = "{customerId}")
    public Customer listCustomers(@PathVariable(name = "customerId") Integer customerId) {
        List<Customer> custs = customers.stream().filter(c -> c.getCustomerId() == customerId).collect(Collectors.toList());
        if(null == custs || custs.size() == 0) {
            return null;
        } else {
            Customer cust = custs.get(0);
            ResponseEntity<Trip[]> resp = restTemplate.getForEntity("http://localhost:9002/tekshila/api/v1/trips/" + customerId, Trip[].class);
            cust.setTrips(Arrays.asList(resp.getBody()));
            return cust;
        }
    }


    @PostMapping(consumes = "application/json")
    public Customer addCustomer(@RequestBody Customer c) {
        System.out.println(c.toString()); //Cannot add to the list created by Arrays.asList
        return c;
    }

//    public static void main(String[] args) {
//
//        //Will throw Unsupported exception as not allowd to add elements to list created by Arrays.asList
//
//
//        CustomerController cc = new CustomerController();
//        cc.customers.add(new Customer());
//        System.out.println(cc.customers.size());
//    }

}
