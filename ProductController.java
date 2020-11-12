package mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductRepository repository;

    @Autowired
    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String showAllProducts(Model model) {
        List<Product> products = repository.findAll();
        model.addAttribute("products", products);
        return "all_products";
    }

    @GetMapping("/add")
    public String showAddForm() {
        return "add_product_form";
    }

    // public String saveNewStudent(@RequestParam Long id, @RequestParam String name, @RequestParam int score) {
    @PostMapping("/add")
    public String saveNewStudent(@ModelAttribute Product newProduct) {
        repository.addProduct(newProduct);
        return "redirect:/products/";
    }
}
