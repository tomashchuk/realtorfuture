package tomashchuk.realtor_project.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
public class Realty {
    @Id
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean is_sold;
    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @ManyToOne
    @JoinColumn(name = "broker_id")
    private Broker broker;
}
