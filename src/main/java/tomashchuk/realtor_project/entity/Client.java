package tomashchuk.realtor_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
