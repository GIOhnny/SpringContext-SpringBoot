package repositories;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
public class ProductRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addProduct(Product product) {
        String sql = "insert into product values (null, ?, ?)";
        jdbcTemplate.update(sql, product.getName(), product.getPrice());
    }

    //overrides the level class of transactional
    //@Transactional(propagation = Propagation.REQUIRES_NEW)
    //@Transactional(propagation = Propagation.MANDATORY)
    //@Transactional(propagation = Propagation.NEVER)
    //@Transactional(propagation = Propagation.SUPPORTS)
    @Transactional(propagation = Propagation.NESTED)
    public void addProduct2(String name, double price) {
        String sql = "insert into product values (null, ?, ?)";
        jdbcTemplate.update(sql, name, price);
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