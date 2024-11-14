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
    public Users getOne(Long id){
        return userRep.findById(String.valueOf(id)).orElseThrow();

    }

    private List<UserDto> usersToUsersDtoMapper(List<Users> userList) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (var user : userList) {
            var userDto = entityToDto(user);
            userDtoList.add(userDto);

        }
        return userDtoList;
    }

    public void delete(String id) {
        userRep.deleteById(id);
    }

    public UserDto add(UserDto userDto) {
        var user = dtoToEntity(userDto);


        return entityToDto(userRep.save(user));
    }

    private static UserDto entityToDto(Users user) {
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .password(user.getPassword())
                .first_name(user.getFirst_name())
                .last_name(user.getLast_name())
                .email(user.getEmail())
                .full_name(user.getFirst_name() + " " + user.getLast_name())
                .build();
    }

    public UserDto update(UserDto userDto) {
        return entityToDto(userRep.save(dtoToEntity(userDto)));

    }

    private static Users dtoToEntity(UserDto userDto) {
        return Users.builder()
                .id(userDto.getId())
                .name(userDto.getName())
                .password(userDto.getPassword())
                .first_name(userDto.getFirst_name())
                .last_name(userDto.getLast_name())
                .email(userDto.getEmail())
                .build();
    }
}
