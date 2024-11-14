package ru.smetanin.recipes.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class RecipeDto {

    private String id;

    private String name;

    private int time;

    private int countOfPortions;

    private LocalDateTime date_publication;

    private Long user;

}
