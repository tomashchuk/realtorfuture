package tomashchuk.realtor_project.service.broker.impls;

import org.springframework.beans.factory.annotation.Autowired;
import tomashchuk.realtor_project.entity.Broker;
import tomashchuk.realtor_project.repository.BrokerRepository;
import tomashchuk.realtor_project.service.broker.interfaces.IBrokerService;

import java.util.List;
import java.util.Optional;

public class BrokerService implements IBrokerService {
    @Autowired
    private BrokerRepository brokerRepository;
    @Override
    public List<Broker> getAll() {
        return brokerRepository.findAll();
    }

    @Override
    public Broker getById(Long id) {
        Optional<Broker> result = brokerRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Broker create(Broker broker) {
        return brokerRepository.save(broker);
    }

    @Override
    public Broker update(Long id, Broker broker) {
        return brokerRepository.save(broker);
    }

    @Override
    public void delete(Long id) {
        brokerRepository.deleteById(id);
    }
}
