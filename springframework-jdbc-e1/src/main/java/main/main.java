package main;

import config.ProjectConfig;
import model.Product;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.ProductRepository;

import java.util.List;

public class main {
    public static void main(String[] args) {
        try (var c = new AnnotationConfigApplicationContext(ProjectConfig.class)) {
            ProductRepository productRepository = c.getBean(ProductRepository.class);

/*
            Product p = new Product();
            p.setName("Bread");
            p.setPrice(5.4);
            productRepository.addProduct(p);
*/

            List<Product> products = productRepository.getProducts();
            products.forEach(System.out::println);
        }
    }
}
