package tomashchuk.realtor_project.stubs;

import tomashchuk.realtor_project.dto.BrokerRequest;
import tomashchuk.realtor_project.entity.Broker;
import tomashchuk.realtor_project.entity.Realty;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public final class BrokerStub {
    public static final Long ID = 1L;
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PATRONIC = "patronic";
    public static final String EMAIL = "email";
    public static final String NUMBER = "number";
    public static final String DESCRIPTION = "description";
    public static final String POSITION = "position";
    public static final Date BIRTHDAY = new Date();
    public static final Date STARTED_WORK = new Date();
    public static  Broker getRandomBroker() {
        return Broker.builder()
                .id(ID)
                .name(NAME)
                .description(DESCRIPTION)
                .surname(SURNAME)
                .patronic(PATRONIC)
                .number(NUMBER)
                .email(EMAIL)
                .birthday(BIRTHDAY)
                .startedWork(STARTED_WORK)
                .position(POSITION)
                .realties(new HashSet<>())
                .build();
    }
    public static BrokerRequest getBrokerRequest() {
        var brokerRequest = new BrokerRequest();
        brokerRequest.setName(NAME);
        brokerRequest.setDescription(DESCRIPTION);
        brokerRequest.setEmail(EMAIL);
        brokerRequest.setNumber(NUMBER);
        brokerRequest.setPatronic(PATRONIC);
        brokerRequest.setSurname(SURNAME);
        brokerRequest.setBirthday(BIRTHDAY);
        brokerRequest.setStartedWork(STARTED_WORK);
        brokerRequest.setPosition(POSITION);
        return brokerRequest;
    }
}
