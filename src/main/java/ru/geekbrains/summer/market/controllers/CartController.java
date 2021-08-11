package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;
import ru.geekbrains.summer.market.utils.Cart;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class  CartController {
    private final Cart cart;
    private final ProductService productService;

    @GetMapping
    public Cart getCart() {
        return cart;
    }

    @GetMapping("/add/{productId}/{amount}")
    public void add(@PathVariable Long productId, @PathVariable Integer amount) {
        if (!cart.add(productId, amount)) {
            cart.add(productService.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Unable add product to cart. Product not found id: " + productId)));
        }
    }
    @GetMapping("/deleteId/{productId}")
    public void deleteById(@PathVariable Long productId){
        cart.deleteById(productId);
    }

    @GetMapping("/clear")
    public  void deleteAll(){
        cart.clear();
    }
}
