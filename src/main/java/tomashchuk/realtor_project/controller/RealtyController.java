package tomashchuk.realtor_project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tomashchuk.realtor_project.dto.RealtyRequest;
import tomashchuk.realtor_project.dto.RealtyResponse;
import tomashchuk.realtor_project.entity.Realty;
import tomashchuk.realtor_project.service.realty.impls.RealtyService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/realties")
public class RealtyController {
    private final RealtyService realtyService;
    @GetMapping
    public List<RealtyResponse> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                                       @RequestParam(required = false, defaultValue = "10") Integer size){
        return realtyService.getAll();
    }
    @GetMapping("/{id}")
    public RealtyResponse getById(@PathVariable Long id){
        return realtyService.getById(id);
    }

    @PostMapping
    public RealtyResponse create(@RequestBody RealtyRequest realty){
        return realtyService.create(realty);
    }

    @PutMapping("/{id}")
    public RealtyResponse update(@PathVariable Long id, @RequestBody Realty realty){
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
