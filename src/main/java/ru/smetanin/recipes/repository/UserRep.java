package ru.smetanin.recipes.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.smetanin.recipes.entity.Users;

@Repository
@Transactional
public interface UserRep extends ListCrudRepository<Users, String> {
}
