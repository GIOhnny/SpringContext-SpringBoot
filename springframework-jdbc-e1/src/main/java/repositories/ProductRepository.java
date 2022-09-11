package repositories;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(Product product) {
        String sql = "insert into product values (null, ?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    public List<Product> getProducts(){
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product p = new Product();
                p.setId(resultSet.getInt("Id"));
                p.setName(resultSet.getString("Name"));
                p.setPrice(resultSet.getDouble("Price"));
                return p;
            }
        });
    }
}