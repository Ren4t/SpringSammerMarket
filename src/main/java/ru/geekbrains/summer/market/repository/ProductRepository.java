package ru.geekbrains.summer.market.repository;

import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.util.NoFindItemListExeption;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init(){
        productList = new ArrayList<>();
        productList.add(new Product(12L,"Milk",65));
        productList.add(new Product(15L,"Coffee",199));
        productList.add(new Product(21L,"Bread",35));
    }

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product getProduct(Long id) throws Exception {
        for (Product product : productList) {
            if(product.getId() == id) {
                return product;
            }
        }
        throw new NoFindItemListExeption();
    }

    public void save(Product product){
        product.setId(productList.stream().mapToLong(Product::getId).max().getAsLong() + 1);
        productList.add(product);
    }
}