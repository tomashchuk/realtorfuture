package tomashchuk.realtor_project.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.Set;

@Data
@Entity
public class Broker {
    @Id
    private String id;
    private String name;
    private String surname;
    private String patronic;
    private String number;
    private String email;
    private String description;
    private Date birthday;
    private Date startedWork;
    private String position;
    @OneToMany(mappedBy = "broker")
    private Set<Realty> realties;
}
