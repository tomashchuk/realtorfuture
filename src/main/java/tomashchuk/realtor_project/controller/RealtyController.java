package tomashchuk.realtor_project.controller;


import org.springframework.web.bind.annotation.*;
import tomashchuk.realtor_project.entity.Realty;
import tomashchuk.realtor_project.service.realty.impls.RealtyService;

import java.util.List;

@RestController
@RequestMapping("/realties")
public class RealtyController {
    RealtyService realtyService;
    @GetMapping
    public List<Realty> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                             @RequestParam(required = false, defaultValue = "10") Integer size){
        return realtyService.getAll();
    }
    @GetMapping("/{id}")
    public Realty getById(@PathVariable Long id){
        return realtyService.getById(id);
    }

    @PostMapping
    public Realty create(@RequestBody Realty realty){
        return realtyService.create(realty);
    }

    @PutMapping("/{id}")
    public Realty update(@PathVariable Long id, @RequestBody Realty realty){
        return realtyService.update(id, realty);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        realtyService.delete(id);
    }

//    @GetMapping("/{typeId}/realties")
//    public List<Realty> getRoomsByType(@PathVariable Long typeId){
//        return null;
//    }
}
