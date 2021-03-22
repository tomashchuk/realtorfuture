package tomashchuk.realtor_project.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    private Long id;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String firstLine;
    private String secondLine;
    private String index;
    @OneToMany(mappedBy = "address")
    private Set<Realty> realties;
}
