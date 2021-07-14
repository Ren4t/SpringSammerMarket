package ru.geekbrains.summer.market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repository.ProductRepository;
import ru.geekbrains.summer.market.util.NoFindItemListExeption;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    public Product getProductbyId(Long id) throws Exception {
        return productRepository.getProduct(id);
    }

    public void addNewProduct(String title, int price){
        if(price < 0) {return;}
        Product product = new Product(null,title,price);
        productRepository.save(product);
    }
}
