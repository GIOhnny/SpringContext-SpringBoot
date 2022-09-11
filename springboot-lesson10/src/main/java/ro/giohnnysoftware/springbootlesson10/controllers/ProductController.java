package ro.giohnnysoftware.springbootlesson10.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.giohnnysoftware.springbootlesson10.services.ProductService;

@RestController
//toate endpointurile trebuie prefixate cu /product
@RequestMapping(path = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add/{name}/{price}")
    public void addProduct(@PathVariable String name,
                           @PathVariable double price) {
        productService.addProduct(name,price);
    }
}
