package tomashchuk.realtor_project.dto;

import lombok.Data;
import tomashchuk.realtor_project.entity.Realty;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Data
public class BrokerRequest {
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
//    private Set<Realty> realties;
}
