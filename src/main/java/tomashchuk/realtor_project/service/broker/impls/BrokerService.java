package tomashchuk.realtor_project.service.broker.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tomashchuk.realtor_project.dto.BrokerRequest;
import tomashchuk.realtor_project.dto.BrokerResponse;
import tomashchuk.realtor_project.entity.Broker;
import tomashchuk.realtor_project.repository.BrokerRepository;
import tomashchuk.realtor_project.service.broker.interfaces.IBrokerService;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BrokerService implements IBrokerService {
    private final BrokerRepository brokerRepository;
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
            return null;
        }
    }

    @Override
    public BrokerResponse create(BrokerRequest broker) {
        var newBroker = Broker.builder()
                .id(new Random().nextLong())
                .description(broker.getDescription())
                .name(broker.getName())
                .surname(broker.getSurname())
                .patronic(broker.getPatronic())
                .email(broker.getEmail())
                .number(broker.getNumber())
                .startedWork(broker.getStartedWork())
                .birthday(broker.getBirthday())
                .build();

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
