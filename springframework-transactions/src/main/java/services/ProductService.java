package services;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repositories.ProductRepository;

@Service
public class ProductService {

    /**
     * REQUIRED (DEFAULT)
     * REQUIRES_MEW
     * MANDATORY
     * NEVER
     * SUPPORTS
     * NOT_SUPPORTED
     * NESTED
     */

    @Autowired
    private ProductRepository productRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void  addTenProducts() {
        for (int i=1;i<=10; i++) {
            productRepository.addProduct2("Product_"+i,i);
            if (i==5) throw new RuntimeException(":( Rollback");
        }
    }

    @Transactional
    //rollsback the RuntimeException but doesn't rollback the checked exception

    //@Transactional (noRollbackFor = RuntimeException.class )
    //forces Spring to not rollback for RuntimeException

    //@Transactional (rollbackFor = Exception.class)
    //Rollsback also for any checkExceptions
    public void addOneProduct() {
        Product p = new Product();
        p.setName("Vodka Stalinskaia");
        p.setPrice(10.5);

        //if we catch the exception the rollback will never occur
        /*
        try {
            throw new RuntimeException(":[");
        }catch (RuntimeException e) {
            e.printStackTrace();
        }
        */

        productRepository.addProduct(p);
        throw new RuntimeException(":(");
    }

}
