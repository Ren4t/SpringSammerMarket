package ru.geekbrains.summer.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.exceptions.MarketError;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.services.ProductService;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;

import java.util.Optional;
import java.util.function.Function;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    private static final Function<Product,ProductDto> mapEntityToDto = product -> new ProductDto(
            product.getId(),product.getTitle(),product.getCategory().getTitle(),product.getPrice());

    @GetMapping(value = "/res/{id}") // ex1 --->
    public ResponseEntity<?> findById2(@PathVariable(name = "id") Long id){
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()) {
            return new ResponseEntity<>(new ProductDto(product.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(new MarketError(HttpStatus.NOT_FOUND.value(),"Product not found, id: " + id),HttpStatus.NOT_FOUND);
        //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       // return product.<ResponseEntity<?>>map(product1 -> new ResponseEntity<>(new ProductDto(product1), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(value = "/{id}") //<--- ex1
    public ProductDto findById(@PathVariable Long id) {
//       Product p = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
//       return new ProductDto(p);
         return mapEntityToDto.apply(productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id)));
    }

    @GetMapping
    public Page<ProductDto> findAll(@RequestParam(name = "p", defaultValue = "1") int pageIndex) {
        //return productService.findPage(pageIndex - 1, 5).map(ProductDto::new);
        return productService.findPage(pageIndex - 1,10).map(mapEntityToDto);
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto newProductDto) {
        Product product = new Product();
        product.setPrice(newProductDto.getPrice());
        product.setTitle(newProductDto.getTitle());
        return new ProductDto(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
