package ru.smetanin.recipes.control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smetanin.recipes.dto.UserDto;
import ru.smetanin.recipes.entity.Users;
import ru.smetanin.recipes.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping("/getAll")
    public List<UserDto> getAll(){
        return userService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable String id){
        userService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping("/add")
    public UserDto add(@RequestBody UserDto  userDto){
        return userService.add(userDto);
    }

    @GetMapping("/getOne/{id}")
    public Users getOne( Long id){
        return userService.getOne(id);
    }

    @PutMapping("/update")
        public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

}
