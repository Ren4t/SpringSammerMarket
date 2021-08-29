package ru.geekbrains.summer.market.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.specifications.ProductSpecifications;

import java.math.BigDecimal;

@Component
public class SpecificationsBuilder {

    public Specification<Product> specificationBuilder (BigDecimal price, String title){
        Specification<Product> spec = Specification.where(null);
        if(price != null ){
            spec = spec.and(ProductSpecifications.priceGreaterOrEqualsThan(price));
        }
        if(title != null ){
            spec = spec.and(ProductSpecifications.titleLike(title));
        }
        return spec;
    }
}
