package dz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {
    private ProductsService productsService;

    @Autowired
    public ProductsController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping
    public String showAllProducts(Model model,
                                  @RequestParam(name = "p", defaultValue = "0") Integer pageNumber,
                                  @RequestParam(name = "min_cost", required = false) Integer minCost,
                                  @RequestParam(name = "max_cost", required = false) Integer maxCost) {
        Specification<Product> spec = Specification.where(null);
        if (minCost != null) {
            spec = spec.and(ProductSpecification.costGEThan(minCost));
        }
        if (maxCost != null) {
            spec = spec.and(ProductSpecification.costLEThan(maxCost));
        }

        List<Product> products = productsService.findAll(spec, pageNumber).getContent();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_product_form";
    }

    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute Product newProduct) {
        productsService.saveOrUpdate(newProduct);
        return "redirect:/products/";
    }

    @GetMapping("/find_by_min_cost")
    @ResponseBody
    public List<Product> findProductsByMinCost(@RequestParam int cost) {
        return productsService.findByMinCost(cost);
    }

    @GetMapping("/find_by_max_cost")
    @ResponseBody
    public List<Product> findProductsByMaxCost(@RequestParam int cost) {
        return productsService.findByMinCost(cost);
    }
}
