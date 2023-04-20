package pl.piomin.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.piomin.payment.domain.Customer;
import pl.piomin.payment.repository.CustomerRepository;

@RestController
@RequestMapping("/users")
public class PaymentController {

    @Autowired
    private CustomerRepository repository;

    public long hardcodeCustomerID = 10;

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Customer all(@PathVariable Long id) {
        Customer customer = repository.findById(hardcodeCustomerID).orElseThrow();
        return customer;
    }
}
