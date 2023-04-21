package pl.piomin.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.piomin.stock.domain.Product;
import pl.piomin.stock.repository.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private ProductRepository repository;

    public long hardcodeCustomerID = 10;

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public Product getProductById(@PathVariable Long id) {
        Product product = repository.findById(id).orElseThrow();
        return product;
    }

    @GetMapping("/")
    @CrossOrigin(origins = "http://localhost:3000")
    public Iterable<Product> getAllProduct() {
        return repository.findAll();
    }
}
