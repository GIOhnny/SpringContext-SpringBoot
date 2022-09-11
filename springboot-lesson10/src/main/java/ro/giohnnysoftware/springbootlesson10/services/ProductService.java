package ro.giohnnysoftware.springbootlesson10.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.giohnnysoftware.springbootlesson10.repositores.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(String name, double price) {
        productRepository.addProduct(name,price);
    }
}
