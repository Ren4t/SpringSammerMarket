package ru.geekbrains.summer.market.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.summer.market.model.MyCart;

@Repository
public interface CartRepository extends JpaRepository<MyCart, Long> {
}
