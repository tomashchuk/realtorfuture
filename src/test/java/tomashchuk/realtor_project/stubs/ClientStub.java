package tomashchuk.realtor_project.stubs;

import tomashchuk.realtor_project.dto.ClientRequest;
import tomashchuk.realtor_project.entity.Client;

import java.util.Date;
import java.util.HashSet;

public final class ClientStub {
    public static final Long ID = 1L;
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String PATRONIC = "patronic";
    public static final String EMAIL = "email";
    public static final String NUMBER = "number";
    public static final String DESCRIPTION = "description";
    public static final Date BIRTHDAY = new Date();
    public static final Date CREATED_AT = new Date();
    public static Client getRandomClient() {
        return Client.builder()
                .id(ID)
                .name(NAME)
                .description(DESCRIPTION)
                .surname(SURNAME)
                .patronic(PATRONIC)
                .number(NUMBER)
                .email(EMAIL)
                .birthday(BIRTHDAY)
                .createdAt(CREATED_AT)
//                .bookings(new HashSet<>())
                .build();
    }
    public static ClientRequest getClientRequest() {
        var clientRequest = new ClientRequest();
        clientRequest.setName(NAME);
        clientRequest.setDescription(DESCRIPTION);
        clientRequest.setEmail(EMAIL);
        clientRequest.setNumber(NUMBER);
        clientRequest.setPatronic(PATRONIC);
        clientRequest.setSurname(SURNAME);
        clientRequest.setBirthday(BIRTHDAY);
        clientRequest.setCreatedAt(CREATED_AT);
        return clientRequest;
    }
}
