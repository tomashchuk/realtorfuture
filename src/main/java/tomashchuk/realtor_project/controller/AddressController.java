package tomashchuk.realtor_project.controller;


import org.springframework.web.bind.annotation.*;
import tomashchuk.realtor_project.entity.Address;
import tomashchuk.realtor_project.repository.AddressRepository;
import tomashchuk.realtor_project.service.address.impls.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    AddressService addressService;
    @GetMapping
    public List<Address> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                                @RequestParam(required = false, defaultValue = "10") Integer size){
        return addressService.getAll();
    }
    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id){
        return addressService.getById(id);
    }

    @PostMapping
    public Address create(@RequestBody Address address){
        return addressService.create(address);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable Long id, @RequestBody Address address){
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        addressService.delete(id);
    }
}
