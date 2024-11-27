package ru.smetanin.recipes.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.smetanin.recipes.entity.Recipe;

import java.util.List;

@Repository
@Transactional
public interface RecipeRepository extends ListCrudRepository<Recipe, String> {

    List<Recipe> findByName(String name);
}
