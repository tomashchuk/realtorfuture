package tomashchuk.realtor_project.dto;

import lombok.Data;
import tomashchuk.realtor_project.entity.Type;
import tomashchuk.realtor_project.entity.Address;
import tomashchuk.realtor_project.entity.Broker;

import java.math.BigDecimal;

@Data
public class RealtyRequest {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean is_sold;
    private TypeResponse type;
//    private Address address;
//    private Broker broker;
}
