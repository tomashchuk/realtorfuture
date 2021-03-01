package tomashchuk.realtor_project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
public class Address {
    @Id
    private String id;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String firstLine;
    private String secondLine;
    private String index;
    @OneToMany(mappedBy = "address")
    private Set<Realty> realties;
}
