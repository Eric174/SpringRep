package dz;

import com.geekbrains.spring.mvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private ProductsRepository productsRepository;

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product saveOrUpdate(Product product) {
        return productsRepository.save(product);
    }

    public Product findById(Long id) {
        return productsRepository.findById(id).orElseThrow(() -> new RuntimeException("Can't found product with id = " + id));
    }

    public Page<Product> findByPage(int pageNumber, int pageSize) {
        return productsRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

    public Page<Product> findAll(Specification<Product> spec, Integer page) {
        if (page < 1L) {
            page = 1;
        }
        return productsRepository.findAll(spec, PageRequest.of(page - 1, 5));
    }

    public List<Product> findByMinCost(int cost) {
        return productsRepository.findAllByCostLessThan(cost);
    }

    public List<Product> findByMaxCost(int cost) {
        return productsRepository.findAllByCostGreaterThan(cost);
    }
}
