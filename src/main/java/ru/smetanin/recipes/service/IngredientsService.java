package ru.smetanin.recipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smetanin.recipes.dto.IngredientsDto;
import ru.smetanin.recipes.entity.Ingredients;
import ru.smetanin.recipes.repository.IngrRep;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class IngredientsService {

    private final IngrRep ingrRep;
    private static Ingredients dtoToEntity(IngredientsDto ingredientsDto) {
        return Ingredients.builder()
                .id(ingredientsDto.getId())
                .name(ingredientsDto.getName())
                .build();
    }
    private static IngredientsDto entityToDto(Ingredients ingredients) {
        return IngredientsDto.builder()
                .id(ingredients.getId())
                .name(ingredients.getName())
                .build();
    }

    private List<IngredientsDto> ingrToIngrDtoMapper(List<Ingredients> ingredientsList) {
        List<IngredientsDto> ingrDtoList = new ArrayList<>();
        for (var ingr : ingredientsList) {
            var ingrDto = entityToDto(ingr);
            ingrDtoList.add(ingrDto);

        }
        return ingrDtoList;
    }




    public List<IngredientsDto> getAll(){
        return ingrToIngrDtoMapper(ingrRep.findAll());
    }

    public IngredientsDto add(IngredientsDto ingredientsDto) {
        var ingr = dtoToEntity(ingredientsDto);
        return entityToDto(ingrRep.save(ingr));
    }

    public Ingredients getOne(String id){
        return ingrRep.findById(String.valueOf(id)).orElseThrow();

    }

    public void delete(String id) {
        ingrRep.deleteById(id);
    }

    public IngredientsDto update(IngredientsDto ingredientsDto) {
        return entityToDto(ingrRep.save(dtoToEntity(ingredientsDto)));

    }
}
