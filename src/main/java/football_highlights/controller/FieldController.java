package football_highlights.controller;

import football_highlights.dto.FieldRequest;
import football_highlights.entity.Field;
import football_highlights.service.FieldService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fields")
@RequiredArgsConstructor
public class FieldController {

    private final FieldService fieldService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Field create(
            @RequestBody @Valid FieldRequest request
            ){
        return fieldService.create(request);
    }

    @GetMapping
    public List<Field> findAll(){
        return fieldService.findAll();
    }

    @GetMapping("/{id}")
    public Field findById(@PathVariable Long id){
        return fieldService.findById(id);
    }

}
