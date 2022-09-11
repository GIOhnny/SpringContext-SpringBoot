package ro.giohnnysoftware.springbootlesson10.repositores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(String name, double price) {
        String sql = "INSERT INTO product VALUES(NULL,?,?)";
        jdbcTemplate.update(sql, name, price);
    }
}
