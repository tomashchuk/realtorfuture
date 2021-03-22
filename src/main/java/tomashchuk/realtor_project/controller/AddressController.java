package tomashchuk.realtor_project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tomashchuk.realtor_project.dto.AddressRequest;
import tomashchuk.realtor_project.dto.AddressResponse;
import tomashchuk.realtor_project.dto.BrokerRequest;
import tomashchuk.realtor_project.dto.BrokerResponse;
import tomashchuk.realtor_project.entity.Address;
import tomashchuk.realtor_project.entity.Broker;
import tomashchuk.realtor_project.repository.AddressRepository;
import tomashchuk.realtor_project.service.address.impls.AddressService;
import tomashchuk.realtor_project.service.broker.impls.BrokerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;
    @GetMapping
    public List<AddressResponse> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                                        @RequestParam(required = false, defaultValue = "10") Integer size){
        return addressService.getAll();
    }
    @GetMapping("/{id}")
    public AddressResponse getById(@PathVariable Long id){
        return addressService.getById(id);
    }

    @PostMapping
    public AddressResponse create(@RequestBody AddressRequest address){
        return addressService.create(address);
    }

    @PutMapping("/{id}")
    public AddressResponse update(@PathVariable Long id, @RequestBody Address address){
        return addressService.update(id, address);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        addressService.delete(id);
    }
}
