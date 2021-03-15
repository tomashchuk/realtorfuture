package tomashchuk.realtor_project.controller;

import org.springframework.web.bind.annotation.*;
import tomashchuk.realtor_project.entity.Client;
import tomashchuk.realtor_project.service.client.impls.ClientService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    ClientService clientService;
    @GetMapping
    public List<Client> getAll(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "10") Integer size){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Client getById(@PathVariable Long id){
        return clientService.getById(id);
    }

    @PostMapping
    public Client create(@RequestBody Client client){
        return clientService.create(client);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable Long id, @RequestBody Client client){
        return clientService.update(id, client);
    }

    @DeleteMapping("/{id}")
    public void delete(Long id){
        clientService.delete(id);
    }
}
