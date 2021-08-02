package ru.geekbrains.summer.market.utils;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import ru.geekbrains.summer.market.dto.OrderItemDto;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.model.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@Data
public class Cart {
    private List<OrderItemDto> items;
    private BigDecimal price;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
        this.price = BigDecimal.ZERO;
    }

    public boolean add(Long productId, Integer amount) {
        for (OrderItemDto o : items) {
            if (o.getProductId().equals(productId)) {
                o.changeQuantity(amount);
                recalculate();
                if(o.getQuantity() == 0) {
                    deleteById(productId);
                }
                return true;
            }
        }
        return false;
    }

    public void add(Product product) {
        items.add(new OrderItemDto(product));
        recalculate();
    }

    public void deleteById(Long productId) {
        for (int i = 0; i < items.size();) {
            if(items.get(i).getProductId().equals(productId)){
                items.remove(i);
                continue;
            }else i++;
        }
        recalculate();
    }

    public void clear() {
        items.clear();
        price = BigDecimal.ZERO;
    }

    private void recalculate() {
        price = BigDecimal.ZERO;
        for (OrderItemDto oid : items) {
            price = price.add(oid.getPrice());
        }
    }
}
