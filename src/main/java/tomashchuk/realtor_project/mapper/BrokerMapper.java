package tomashchuk.realtor_project.mapper;

import tomashchuk.realtor_project.dto.BrokerRequest;
import tomashchuk.realtor_project.entity.Broker;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;


@Component
public class BrokerMapper {
    public Broker fromRequest(BrokerRequest request) {
        return Broker.builder()
                .id(new Random().nextLong())
                .name(request.getName())
                .surname(request.getSurname())
                .patronic(request.getPatronic())
                .number(request.getNumber())
                .email(request.getEmail())
                .description(request.getDescription())
                .birthday(request.getBirthday())
                .startedWork(request.getStartedWork())
                .position(request.getPosition())
                .realties(new HashSet<>())
                .build();
    }
}
