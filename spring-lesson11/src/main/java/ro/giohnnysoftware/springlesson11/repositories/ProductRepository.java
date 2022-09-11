package ro.giohnnysoftware.springlesson11.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ro.giohnnysoftware.springlesson11.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    //se implementeaza automat de catre Spring Data daca numele este agreat
    //daca se pune @Query JPA executa query ul dat
    //@Query("SELECT p FROM Product p WHERE p.name=:name")
    Product findProductByName(String name);
}
