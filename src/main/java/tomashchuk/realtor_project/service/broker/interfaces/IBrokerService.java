package tomashchuk.realtor_project.service.broker.interfaces;

import tomashchuk.realtor_project.dto.BrokerRequest;
import tomashchuk.realtor_project.dto.BrokerResponse;
import tomashchuk.realtor_project.entity.Broker;

import java.util.List;

public interface IBrokerService {
    List<BrokerResponse> getAll();
    BrokerResponse getById(Long id);
    BrokerResponse create(BrokerRequest broker);
    BrokerResponse update(Long id, Broker broker);
    void delete(Long id);
}
