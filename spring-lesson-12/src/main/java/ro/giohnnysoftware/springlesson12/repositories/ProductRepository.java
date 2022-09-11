package ro.giohnnysoftware.springlesson12.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.giohnnysoftware.springlesson12.entities.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findProductsByName(String name, Sort id);
}
