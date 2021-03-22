package tomashchuk.realtor_project.dto;

import tomashchuk.realtor_project.entity.Realty;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RealtyResponse {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Boolean is_sold;
    private TypeResponse type;

    public static RealtyResponse mapToRealtyResponse(Realty realty) {
        RealtyResponse realtyResponse = new RealtyResponse();

        realtyResponse.setId(realty.getId());
        realtyResponse.setDescription(realty.getDescription());
        realtyResponse.setName(realty.getName());
        realtyResponse.setPrice(realty.getPrice());
        realtyResponse.setIs_sold(realty.getIs_sold());
        realtyResponse.setType(TypeResponse.mapToTypeResponse(realty.getType()));

        return realtyResponse;
    }
}
