package tomashchuk.realtor_project.service.client.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tomashchuk.realtor_project.dto.ClientResponse;
import tomashchuk.realtor_project.dto.ClientRequest;
import tomashchuk.realtor_project.dto.TypeResponse;
import tomashchuk.realtor_project.entity.Client;
import tomashchuk.realtor_project.mapper.ClientMapper;
import tomashchuk.realtor_project.repository.ClientRepository;
import tomashchuk.realtor_project.service.client.interfaces.IClientService;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ClientService implements IClientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    public List<ClientResponse> getAll() {
        var clients = clientRepository.findAll();
        return clients.stream().map(ClientResponse::mapToClientResponse).collect(Collectors.toList());
    }

    @Override
    public ClientResponse getById(Long id) {
        Optional<Client> result = clientRepository.findById(id);
        if (result.isPresent()) {
            return ClientResponse.mapToClientResponse(result.get());
        } else {
            return ClientResponse.mapToClientResponse(result.orElseThrow());
        }
    }

    @Override
    public ClientResponse create(ClientRequest client) {
        var newClient = clientMapper.fromRequest(client);

        return ClientResponse.mapToClientResponse(clientRepository.save(newClient));
    }

    @Override
    public ClientResponse update(Long id, Client client) {
        return ClientResponse.mapToClientResponse(clientRepository.save(client));
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
