package mvc;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {
    List<Product> productList;

    @PostConstruct
    public void init() {
        this.productList = new ArrayList<>();
        this.productList.add(new Product("Pen", 10));
        this.productList.add(new Product("Pencil", 20));
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(productList);
    }

    public Product getById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }

    public Product addProduct(Product product) {
        product.setId(Product.getMaxId());
        Product.setId_class(product.getId()+1);
        productList.add(product);
        return product;
    }
}
