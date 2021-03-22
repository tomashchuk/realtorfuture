package tomashchuk.realtor_project.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ClientRequest {
    private Long id;
    private String name;
    private String surname;
    private String patronic;
    private String number;
    private String email;
    private String description;
    private Date birthday;
    private Date createdAt;
}
