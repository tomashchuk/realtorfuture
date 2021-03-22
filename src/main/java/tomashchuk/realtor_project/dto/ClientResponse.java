package tomashchuk.realtor_project.dto;

import lombok.Data;
import tomashchuk.realtor_project.entity.Client;

import java.util.Date;

@Data
public class ClientResponse {
    private Long id;
    private String name;
    private String surname;
    private String patronic;
    private String number;
    private String email;
    private String description;
    private Date birthday;
    private Date createdAt;

    public static ClientResponse mapToClientResponse(Client client) {
        ClientResponse clientResponse = new ClientResponse();

        clientResponse.setId(client.getId());
        clientResponse.setDescription(client.getDescription());
        clientResponse.setName(client.getName());
        clientResponse.setSurname(client.getSurname());
        clientResponse.setPatronic(client.getPatronic());
        clientResponse.setNumber(client.getNumber());
        clientResponse.setEmail(client.getEmail());
        clientResponse.setBirthday(client.getBirthday());
        clientResponse.setCreatedAt(client.getCreatedAt());

        return clientResponse;
    }
}
