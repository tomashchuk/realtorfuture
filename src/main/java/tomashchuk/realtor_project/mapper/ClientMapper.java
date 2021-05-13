package tomashchuk.realtor_project.mapper;

import tomashchuk.realtor_project.dto.ClientRequest;
import tomashchuk.realtor_project.entity.Client;
import org.springframework.stereotype.Component;

import java.util.Random;


@Component
public class ClientMapper {
    public Client fromRequest(ClientRequest request) {
        return Client.builder()
                .id(new Random().nextLong())
                .name(request.getName())
                .surname(request.getSurname())
                .patronic(request.getPatronic())
                .number(request.getNumber())
                .email(request.getEmail())
                .description(request.getDescription())
                .birthday(request.getBirthday())
                .createdAt(request.getCreatedAt())
                .build();
    }
}
