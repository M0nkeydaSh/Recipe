package ru.smetanin.recipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smetanin.recipes.dto.RecipeDto;
import ru.smetanin.recipes.entity.Recipe;
import ru.smetanin.recipes.repository.RecipeRepository;
import ru.smetanin.recipes.repository.UserRep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Service
@RequiredArgsConstructor
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final UserRep userRep;

    public List<RecipeDto> getAll(String name) {
        List<Recipe> recipes;
        if (name != null && !name.isBlank()) {
            recipes = recipeRepository.findByNameContainingIgnoreCase(name);
        } else {
            recipes = recipeRepository.findAll();
        }
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
                user(recipe.getUsers().getId()).
                build();
    }

    public void delete(String id) {
        recipeRepository.deleteById(id);
    }


    public RecipeDto add(RecipeDto recipeDto) {
        var recipe = dtoToEntity(recipeDto);
        var user = userRep.findById(recipeDto.getUser().toString()).orElseThrow();
        recipe.setUsers(user);
        return entityToDto(recipeRepository.save(recipe));
    }

    private Recipe dtoToEntity(RecipeDto recipeDto) {
        var recipe = Recipe.builder()
                .id(recipeDto.getId())
                .name(recipeDto.getName())
                .time(recipeDto.getTime())
                .countOfPortion(recipeDto.getCountOfPortions())
                .datePublication(recipeDto.getDate_publication())
                .build();
        var user = userRep.findById(recipeDto.getUser().toString()).orElseThrow();
        recipe.setUsers(user);
        return recipe;
    }

    public RecipeDto getOne(String id) {
        var recipeOne = recipeRepository.findById(id).orElseThrow();

        return entityToDto(recipeOne);
    }

    public RecipeDto getRandomRecipe() {
        List<Recipe> recipes = recipeRepository.findAll();
        Random random = new Random();
        String id = String.valueOf((random.nextInt(recipes.size())+1));
        var recipeOne = recipeRepository.findById(id).orElseThrow();

        return entityToDto(recipeOne);
    }

    public RecipeDto update(RecipeDto recipeDto) {

//        var recipe = recipeRepository.findById(recipeDto.getId()).orElseThrow();
//        recipe.setName(recipeDto.getName());
//        recipe.setTime(recipeDto.getTime());
//        recipe.setCountOfPortion(recipeDto.getCountOfPortions());
//        recipe.setDatePublication(recipeDto.getDate_publication());

        return entityToDto(recipeRepository.save(dtoToEntity(recipeDto)));
    }
}
