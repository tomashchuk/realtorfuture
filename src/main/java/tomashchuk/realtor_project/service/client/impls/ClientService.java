package tomashchuk.realtor_project.service.client.impls;

import org.springframework.beans.factory.annotation.Autowired;
import tomashchuk.realtor_project.entity.Client;
import tomashchuk.realtor_project.repository.ClientRepository;
import tomashchuk.realtor_project.service.client.interfaces.IClientService;

import java.util.List;
import java.util.Optional;

public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        Optional<Client> result = clientRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client update(Long id, Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
