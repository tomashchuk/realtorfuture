package tomashchuk.realtor_project.controller;


import org.springframework.web.bind.annotation.*;
import tomashchuk.realtor_project.entity.Broker;
import tomashchuk.realtor_project.repository.BrokerRepository;
import tomashchuk.realtor_project.service.broker.impls.BrokerService;

import java.util.List;

@RestController
@RequestMapping("/brokers")
public class BrokerController {
    BrokerService brokerService;
    @GetMapping
    public List<Broker> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "10") Integer size){
        return brokerService.getAll();
    }
    @GetMapping("/{id}")
    public Broker getById(@PathVariable Long id){
        return brokerService.getById(id);
    }

    @PostMapping
    public Broker create(@RequestBody Broker broker){
        return brokerService.create(broker);
    }

    @PutMapping("/{id}")
    public Broker update(@PathVariable Long id, @RequestBody Broker broker){
        return brokerService.update(id, broker);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        brokerService.delete(id);
    }
}
