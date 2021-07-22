package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    // GET http://localhost:8189/summer
    @GetMapping
    public Page<Product> findAll(@RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        return productService.findPage(pageIndex - 1, 10);
    }

    @GetMapping("/{id}")
    public ProductDto showProduct(@PathVariable Long id) {
        return new ProductDto(productService.findById(id));
    }

    @PostMapping
    public ProductDto crateNewProduct(@RequestBody ProductDto newProductDto) {
        Product newProduct = new Product();
        newProduct.setTitle(newProductDto.getTitle());
        newProduct.setPrice(newProductDto.getPrice());
        return new ProductDto(productService.save(newProduct));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
