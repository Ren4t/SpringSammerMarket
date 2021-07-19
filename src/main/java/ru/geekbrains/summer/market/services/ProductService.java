package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.ProductRepository;
import ru.geekbrains.summer.market.utils.QuickSort;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final QuickSort quickSort;

    public List<Product> findAll() {

        return productRepository.findAll();
    }

    public List<Product> sortedListMin() {

        List<Product> listProducts = productRepository.findAll();
        quickSort.quickSort(listProducts);
        return listProducts;
    }

    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }

    public void saveNewProduct(String title, int price) {
        Product product = new Product();
        product.setTitle(title);
        product.setPrice(price);
        if (product.getPrice() <= 0) {
            return;
        }
        productRepository.save(product);
    }

    public List<Product> findByMinPrice(int minPrice) {
        return productRepository.findAllByPriceGreaterThanEqual(minPrice);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
