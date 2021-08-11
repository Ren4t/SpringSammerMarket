package ru.geekbrains.summer.market.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.summer.market.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
