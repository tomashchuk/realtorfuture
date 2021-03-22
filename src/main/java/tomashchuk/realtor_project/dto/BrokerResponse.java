package tomashchuk.realtor_project.dto;

import lombok.Data;
import tomashchuk.realtor_project.entity.Broker;

import java.util.Date;

@Data
public class BrokerResponse {
    private Long id;
    private String name;
    private String surname;
    private String patronic;
    private String number;
    private String email;
    private String description;
    private Date birthday;
    private Date startedWork;
    private String position;

    public static BrokerResponse mapToBrokerResponse(Broker broker) {
        BrokerResponse brokerResponse = new BrokerResponse();

        brokerResponse.setId(broker.getId());
        brokerResponse.setDescription(broker.getDescription());
        brokerResponse.setName(broker.getName());
        brokerResponse.setSurname(broker.getSurname());
        brokerResponse.setPatronic(broker.getPatronic());
        brokerResponse.setNumber(broker.getNumber());
        brokerResponse.setEmail(broker.getEmail());
        brokerResponse.setBirthday(broker.getBirthday());
        brokerResponse.setStartedWork(broker.getStartedWork());
        brokerResponse.setPosition(broker.getPosition());

        return brokerResponse;
    }
}
