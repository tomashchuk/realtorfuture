package tomashchuk.realtor_project.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RealtyRequest {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean is_sold;
    private TypeResponse type;
}
