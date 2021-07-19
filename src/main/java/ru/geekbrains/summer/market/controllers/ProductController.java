package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.services.ProductService;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    // GET http://localhost:8189/summer

}
