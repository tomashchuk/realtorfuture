package tomashchuk.realtor_project.service.broker.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tomashchuk.realtor_project.dto.BrokerRequest;
import tomashchuk.realtor_project.dto.BrokerResponse;
import tomashchuk.realtor_project.entity.Broker;
import tomashchuk.realtor_project.mapper.BrokerMapper;
import tomashchuk.realtor_project.repository.BrokerRepository;
import tomashchuk.realtor_project.service.broker.interfaces.IBrokerService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BrokerService implements IBrokerService {
    private final BrokerRepository brokerRepository;
    private final BrokerMapper brokerMapper;
    @Override
    public List<BrokerResponse> getAll() {
        var brokers = brokerRepository.findAll();
        return brokers.stream().map(BrokerResponse::mapToBrokerResponse).collect(Collectors.toList());
    }

    @Override
    public BrokerResponse getById(Long id) {
        Optional<Broker> result = brokerRepository.findById(id);
        if (result.isPresent()) {
            return BrokerResponse.mapToBrokerResponse(result.get());
        } else {
            return BrokerResponse.mapToBrokerResponse(result.orElseThrow());
        }
    }

    @Override
    public BrokerResponse create(BrokerRequest broker) {
        var newBroker = brokerMapper.fromRequest(broker);

        return BrokerResponse.mapToBrokerResponse(brokerRepository.save(newBroker));
    }

    @Override
    public BrokerResponse update(Long id, Broker broker) {
        return BrokerResponse.mapToBrokerResponse(brokerRepository.save(broker));
    }

    @Override
    public void delete(Long id) {
        brokerRepository.deleteById(id);
    }
}
