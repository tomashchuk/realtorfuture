package tomashchuk.realtor_project.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tomashchuk.realtor_project.dto.BrokerRequest;
import tomashchuk.realtor_project.dto.BrokerResponse;
import tomashchuk.realtor_project.entity.Broker;
import tomashchuk.realtor_project.service.broker.impls.BrokerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/brokers")
public class BrokerController {
    private final BrokerService brokerService;
    @GetMapping
    public List<BrokerResponse> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                                       @RequestParam(required = false, defaultValue = "10") Integer size){
        return brokerService.getAll();
    }
    @GetMapping("/{id}")
    public BrokerResponse getById(@PathVariable Long id){
        return brokerService.getById(id);
    }

    @PostMapping
    public BrokerResponse create(@RequestBody BrokerRequest broker){
        return brokerService.create(broker);
    }

    @PutMapping("/{id}")
    public BrokerResponse update(@PathVariable Long id, @RequestBody Broker broker){
        return brokerService.update(id, broker);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        brokerService.delete(id);
    }
}
