package tomashchuk.realtor_project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Client {
    @Id
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
