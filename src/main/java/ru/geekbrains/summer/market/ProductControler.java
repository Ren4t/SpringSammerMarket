package ru.geekbrains.summer.market;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductControler {

        AnnotationConfigApplicationContext applicationContext;

        @GetMapping("/")
        public String start() {
           applicationContext = new AnnotationConfigApplicationContext();
            return "/products";
        }

        @GetMapping("/show_products")
        public String showProducts(Model model) {
            ProductRepository products = applicationContext.getBean(ProductRepository.class);
            model.addAttribute("listProducts",products.getProductList());
            return "/products";
        }

        @PostMapping("/add_product")
        public String addProduct(Long id,String name,int cost) {
            ProductRepository products = applicationContext.getBean(ProductRepository.class);
            products.getProductList().add(new Product(id,name,cost));
            return "redirect:/show_products";
        }
}
