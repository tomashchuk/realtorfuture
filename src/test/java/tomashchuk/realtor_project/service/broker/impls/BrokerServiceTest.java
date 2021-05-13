package tomashchuk.realtor_project.service.broker.impls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import tomashchuk.realtor_project.entity.Broker;
import tomashchuk.realtor_project.entity.Type;
import tomashchuk.realtor_project.mapper.BrokerMapper;
import tomashchuk.realtor_project.repository.BrokerRepository;
import tomashchuk.realtor_project.stubs.BrokerStub;
import tomashchuk.realtor_project.stubs.TypeStub;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

public class BrokerServiceTest {
    private BrokerService service;
    @Mock
    private BrokerRepository brokerRepository;
    @Mock
    private BrokerMapper brokerMapper;

    @BeforeEach
    void setup() {
        service = new BrokerService(brokerRepository, brokerMapper);
    }

    @Test
    void getSuccessful() {
        List<Broker> list = new ArrayList<Broker>();
        var broker = BrokerStub.getRandomBroker();
        list.add(broker);
        list.add(broker);
        list.add(broker);

        when(brokerRepository.findAll()).thenReturn(list);
        var getAll = service.getAll();
        assertEquals(list.size(), getAll.size());
    }

    @Test
    void getSuccessfulById() {
        var broker = BrokerStub.getRandomBroker();
        when(brokerRepository.findById(Mockito.any())).thenReturn(Optional.of(broker));
        var byId = service.getById(BrokerStub.ID);

        assertAll(() -> assertEquals(byId.getId(), broker.getId()),
                () -> assertEquals(byId.getName(), broker.getName()),
                () -> assertEquals(byId.getEmail(), broker.getEmail()),
                () -> assertEquals(byId.getNumber(), broker.getNumber()),
                () -> assertEquals(byId.getSurname(), broker.getSurname()),
                () -> assertEquals(byId.getPatronic(), broker.getPatronic()),
                () -> assertEquals(byId.getDescription(), broker.getDescription()),
                () -> assertEquals(byId.getBirthday(), broker.getBirthday()),
                () -> assertEquals(byId.getStartedWork(), broker.getStartedWork()),
                () -> assertEquals(byId.getPosition(), broker.getPosition())
        );

    }

    @Test
    void getFailedById() {
        when(brokerRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        var e = assertThrows(NoSuchElementException.class, () -> service.getById(BrokerStub.ID));
        assertEquals(e.getMessage(), "No value present");
    }

    @Test
    void createSuccessful() {
        var captor = ArgumentCaptor.forClass(Broker.class);
        var broker = BrokerStub.getRandomBroker();
        when(brokerMapper.fromRequest(Mockito.any())).thenReturn(broker);
        when(brokerRepository.save(Mockito.any())).thenReturn(BrokerStub.getRandomBroker());
        var result = service.create(BrokerStub.getBrokerRequest());
        Mockito.verify(brokerRepository, atLeast(1)).save(captor.capture());
        assertEquals(broker, captor.getValue());
        assertEquals(broker.getName(), result.getName());
        assertEquals(broker.getId(), result.getId());
        assertEquals(broker.getEmail(), result.getEmail());
        assertEquals(broker.getSurname(), result.getSurname());
    }

    @Test
    void updateSuccessful() {
        var captor = ArgumentCaptor.forClass(Broker.class);
        var broker = BrokerStub.getRandomBroker();
        when(brokerRepository.save(Mockito.any())).thenReturn(BrokerStub.getRandomBroker());
        var result = service.update(BrokerStub.ID, BrokerStub.getRandomBroker());
        Mockito.verify(brokerRepository, atLeast(1)).save(captor.capture());
        assertEquals(broker, captor.getValue());
        assertEquals(broker.getName(), result.getName());
    }

    @Test
    void deleteSuccessful() {
        service.delete(BrokerStub.ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(brokerRepository, atLeast(1)).deleteById(captor.capture());
        assertEquals(BrokerStub.ID, captor.getValue());
    }

}
