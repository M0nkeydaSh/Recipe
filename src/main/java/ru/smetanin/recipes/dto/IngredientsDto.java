package ru.smetanin.recipes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientsDto {

    private String id;

    private String name;
}
