package ru.geekbrains.summer.market.controlers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repository.ProductRepository;
import ru.geekbrains.summer.market.service.ProductService;

@Controller
public class ProductControler {
    private ProductService productService;

    @Autowired
    public ProductControler(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showProducts(Model model) {
        model.addAttribute("listProducts", productService.getProductList());
        return "index";
    }

    @GetMapping("/product/add")
    public String addProductForm() {
        return "add_product_form";
    }
    @PostMapping("/product/add")
    public String addNewProduct(@RequestParam String title,
                                @RequestParam int price) {
        productService.addNewProduct(title,price);
        return "redirect:/";
    }

//    @PostMapping("/add_product")
//    public String addProduct(Long id, String name, int cost) {
//        ProductRepository products = applicationContext.getBean(ProductRepository.class);
//        products.getProductList().add(new Product(id, name, cost));
//        return "redirect:/show_products";
//    }
}
