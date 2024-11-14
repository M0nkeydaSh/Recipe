package ru.smetanin.recipes.control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.smetanin.recipes.dto.RecipeDto;
import ru.smetanin.recipes.service.RecipeService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/recipes")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping("/getAll")
    public List<RecipeDto> getAll() {
        return recipeService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable String id) {
        recipeService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping("/add")
    public RecipeDto add(@RequestBody RecipeDto recipeDto) {
        return recipeService.add(recipeDto);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<RecipeDto> getOne(@PathVariable String id) {
        return new ResponseEntity<>(recipeService.getOne(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public RecipeDto update(@RequestBody RecipeDto recipeDto) {
        return recipeService.update(recipeDto);
    }

}

