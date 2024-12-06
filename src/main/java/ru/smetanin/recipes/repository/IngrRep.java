package ru.smetanin.recipes.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.smetanin.recipes.entity.Ingredients;

@Repository
@Transactional
public interface IngrRep extends ListCrudRepository<Ingredients, String> {


}
