package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.model.MyCart;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.CartRepository;
import ru.geekbrains.summer.market.utils.Cart;

@Service
@RequiredArgsConstructor
public class MyCartService {
    private final CartRepository cartRepository;
    private final ProductService productService;

    public MyCart save(Product product) {
        MyCart mycart = new MyCart();
        mycart.setProduct(product.getTitle());
        return cartRepository.save(mycart);
    }
}