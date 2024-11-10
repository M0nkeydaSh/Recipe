package ru.smetanin.recipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smetanin.recipes.dto.RecipeDto;
import ru.smetanin.recipes.dto.UserDto;
import ru.smetanin.recipes.entity.Recipe;
import ru.smetanin.recipes.repository.RecipeRepository;
import ru.smetanin.recipes.repository.UserRep;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final UserRep userRep;
    public List<RecipeDto> getAll(){
        var recipes = recipeRepository.findAll();

        return recipeToRecipeDtoMapper(recipes);
    }

    private List<RecipeDto> recipeToRecipeDtoMapper(List<Recipe> recipeList) {
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        for (var recipe : recipeList) {
            recipeDtoList.add(entityToDto(recipe));

        }
        return recipeDtoList;
    }

    private static RecipeDto entityToDto(Recipe recipe) {
        return RecipeDto.builder().
                id(recipe.getId()).
                name(recipe.getName()).
                time(recipe.getTime()).
                countOfPortions(recipe.getCountOfPortion()).
                date_publication(recipe.getDatePublication()).
                user(UserDto.builder().
                        id(recipe.getUsers().getId()).
                        name(recipe.getUsers().getName()).
                        password(recipe.getUsers().getPassword()).
                        first_name(recipe.getUsers().getFirst_name()).
                        last_name(recipe.getUsers().getLast_name()).
                        full_name(recipe.getUsers().getFirst_name() + " " + recipe.getUsers().getLast_name()).
                        email(recipe.getUsers().getEmail())
                        .build()).
                build();
    }

    public void delete(String id) {
        recipeRepository.deleteById(id);
    }


    public RecipeDto add(RecipeDto recipeDto) {
        var recipe = Recipe.builder()
                .id(recipeDto.getId())
                .name(recipeDto.getName())
                .time(recipeDto.getTime())
                .countOfPortion(recipeDto.getCountOfPortions())
                .datePublication(recipeDto.getDate_publication()).build();
        var user = userRep.findById(String.valueOf(recipeDto.getUser().getId())).orElseThrow();
        recipe.setUsers(user);

        return entityToDto(recipeRepository.save(recipe));
    }
}
