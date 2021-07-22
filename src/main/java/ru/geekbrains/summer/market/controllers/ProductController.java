package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // GET http://localhost:8189/summer
    @GetMapping("/products")
    public List<Product> showAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public Product showProduct(@PathVariable Long id){
        return productService.findById(id);
    }

    @GetMapping("/delete/{id}")
        public void deleteProduct(@PathVariable Long id){
            productService.deleteById(id);
        }
    @GetMapping("/page")
    public Page<Product> showPage(@RequestParam(name = "p") int pageIndex){
        return productService.findPage(pageIndex -1, 10);
    }

}
