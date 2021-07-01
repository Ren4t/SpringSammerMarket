package ru.geekbrains.summer.market;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        productList.add(new Product(12L,"product",123));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product getProduct(int ind) throws Exception {
        for (Product product : productList) {
            if(product.getId() == ind) {
                return product;
            }
        }
        throw new Exception();
    }
}