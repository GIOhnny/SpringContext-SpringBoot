package ro.giohnnysoftware.springlesson12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ro.giohnnysoftware.springlesson12.entities.Product;
import ro.giohnnysoftware.springlesson12.repositories.ProductRepository;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/sort")
    public List<Product> getAllSortedDescendingById() {
        return productRepository.findAll(Sort.by("price").and(Sort.by("id")).descending());
    }

    @GetMapping("/page/{page}")
    public List<Product> getProductsByPage(@PathVariable int page) {
        Sort s = Sort.by("price").descending();
        return productRepository.findAll(PageRequest.of(page, 3, s)).getContent();
        //return productRepository.findAll(PageRequest.of(page, 3)).getContent();
    }

    @GetMapping("/name/{name}")
    public List<Product> getProductsByName(@PathVariable String name) {
        return productRepository.findProductsByName(name, Sort.by("Id").descending());
        //return productRepository.findAll(PageRequest.of(page, 3)).getContent();
    }

}
