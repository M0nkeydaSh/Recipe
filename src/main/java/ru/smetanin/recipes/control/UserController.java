package ru.smetanin.recipes.control;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.smetanin.recipes.dto.UserDto;
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
}


// /api/v1/user/getAll
