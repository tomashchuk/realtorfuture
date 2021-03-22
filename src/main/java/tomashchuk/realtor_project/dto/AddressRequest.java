package tomashchuk.realtor_project.dto;

import lombok.Data;
import tomashchuk.realtor_project.entity.Realty;

import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class AddressRequest {
    private Long id;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String firstLine;
    private String secondLine;
    private String index;
//    @OneToMany(mappedBy = "address")
//    private Set<Realty> realties;
}
