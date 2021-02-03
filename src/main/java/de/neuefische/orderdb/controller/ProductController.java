package de.neuefische.orderdb.controller;

import de.neuefische.orderdb.model.Product;
import de.neuefische.orderdb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ArrayList<Product> listProducts() {
        return productService.listProducts();

    }

    @GetMapping("{id}")
    public Product findProductById(@PathVariable String id) {
       if (productService.findProductById(id).isPresent()) {
           return productService.findProductById(id).get();
       }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id " + id + " not found");

    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @GetMapping("search")
    public Product searchProductByName(@RequestParam String name) {
        if (productService.searchProductByName(name).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with name " + " does not exist");
        }
        return productService.searchProductByName(name).get();
    }

}
