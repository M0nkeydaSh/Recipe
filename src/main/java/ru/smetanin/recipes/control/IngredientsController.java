package ru.smetanin.recipes.control;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.smetanin.recipes.dto.IngredientsDto;
import ru.smetanin.recipes.entity.Ingredients;
import ru.smetanin.recipes.service.IngredientsService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientsController {


    private final IngredientsService ingredientsService;

    @GetMapping("/getAll")
    public List<IngredientsDto> getAll(){
        return ingredientsService.getAll();
    }

    @PostMapping("/add")
    public IngredientsDto add(@RequestBody IngredientsDto  ingredientsDto){
        return ingredientsService.add(ingredientsDto);
    }

    @DeleteMapping("/delete/{id}")
    public HttpStatus delete(@PathVariable String id){
        ingredientsService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/getOne/{id}")
    public Ingredients getOne(String id){
        return ingredientsService.getOne(id);
    }

    @PutMapping("/update")
    public IngredientsDto update(@RequestBody IngredientsDto ingredientsDto) {
        return ingredientsService.update(ingredientsDto);
    }
}
