package ru.smetanin.recipes.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

    private Long id;

    private String name;

    private String password;

    private String first_name;

    private String last_name;

    private String email;

    private String full_name;


}
