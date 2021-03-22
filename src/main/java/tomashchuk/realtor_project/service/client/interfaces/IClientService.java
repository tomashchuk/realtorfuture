package tomashchuk.realtor_project.service.client.interfaces;

import tomashchuk.realtor_project.dto.ClientRequest;
import tomashchuk.realtor_project.dto.ClientResponse;
import tomashchuk.realtor_project.dto.RealtyResponse;
import tomashchuk.realtor_project.entity.Client;

import java.util.List;

public interface IClientService {
    List<ClientResponse> getAll();
    ClientResponse getById(Long id);
    ClientResponse create(ClientRequest client);
    ClientResponse update(Long id, Client client);
    void delete(Long id);
}
