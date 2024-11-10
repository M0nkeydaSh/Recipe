package ru.smetanin.recipes.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.smetanin.recipes.dto.UserDto;
import ru.smetanin.recipes.entity.Users;
import ru.smetanin.recipes.repository.UserRep;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRep userRep;

    public List<UserDto> getAll(){
        var usersList = userRep.findAll();
        return usersToUsersDtoMapper(usersList);

    }

    private List<UserDto> usersToUsersDtoMapper(List<Users> userList) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (var user : userList) {
            var userDto = UserDto.builder().id(user.getId()).
                            name(user.getName()).password(user.getPassword()).
                            first_name(user.getFirst_name()).
                            last_name(user.getLast_name()).
                            email(user.getEmail()).
                            full_name(user.getFirst_name() + " " + user.getLast_name()).
                            build();
            userDtoList.add(userDto);

        }
        return userDtoList;
    }
}
