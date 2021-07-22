package ru.geekbrains.summer.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.summer.market.model.Category;
import ru.geekbrains.summer.market.model.Product;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;
    private List<String> products;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
        this.products = category.getProducts()
                .stream()
                .map(product -> new ProductDto(product).getTitle())
                .collect(Collectors.toList());
    }

}
