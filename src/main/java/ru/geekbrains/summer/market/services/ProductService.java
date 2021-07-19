package ru.geekbrains.summer.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.ProductRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }


    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }


    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Page<Product> findPage(int pageIndex, int pageSize){
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }
}
