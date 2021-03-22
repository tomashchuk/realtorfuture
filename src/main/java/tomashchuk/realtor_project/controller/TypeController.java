package tomashchuk.realtor_project.controller;
//
//public class TypeController {
//}


import tomashchuk.realtor_project.entity.Type;
import tomashchuk.realtor_project.service.type.impls.TypeService;
import tomashchuk.realtor_project.dto.TypeRequest;
import tomashchuk.realtor_project.dto.TypeResponse;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/types")
public class TypeController {
    private final TypeService typeService;
    @GetMapping
    public List<TypeResponse> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                                     @RequestParam(required = false, defaultValue = "10") Integer size){
        return typeService.getAll();
    }
    @GetMapping("/{id}")
    public TypeResponse getById(@PathVariable Long id){
        return typeService.getById(id);
    }

    @PostMapping
    public TypeResponse create(@RequestBody TypeRequest type){
        return typeService.create(type);
    }

    @PutMapping("/{id}")
    public TypeResponse update(@PathVariable Long id, @RequestBody Type type){
        return typeService.update(id, type);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        typeService.delete(id);
    }
}

