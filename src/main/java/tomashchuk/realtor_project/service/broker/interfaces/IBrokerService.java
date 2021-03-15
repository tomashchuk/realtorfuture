package tomashchuk.realtor_project.service.broker.interfaces;

import tomashchuk.realtor_project.entity.Broker;

import java.util.List;

public interface IBrokerService {
    List<Broker> getAll();
    Broker getById(Long id);
    Broker create(Broker broker);
    Broker update(Long id, Broker broker);
    void delete(Long id);
}
