package ru.smetanin.recipes.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.smetanin.recipes.entity.Ingredients;

import java.util.List;

@Repository
@Transactional
public interface IngrRep extends ListCrudRepository<Ingredients, String> {

    List<Ingredients> findByName(String name);

    List<Ingredients> findByNameContaining(String name);

    List<Ingredients> findByNameContainingIgnoreCase(String name);


}
