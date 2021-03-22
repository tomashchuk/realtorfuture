package tomashchuk.realtor_project.dto;

import lombok.Data;
import tomashchuk.realtor_project.entity.Address;

import java.math.BigDecimal;
//import java.util.Set;

@Data
public class AddressResponse {
    private Long id;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private String firstLine;
    private String secondLine;
    private String index;
//    @OneToMany(mappedBy = "address")
//    private Set<Realty> realties;

    public static AddressResponse mapToAddressResponse(Address address) {
        AddressResponse addressResponse = new AddressResponse();

        addressResponse.setId(address.getId());
        addressResponse.setLongitude(address.getLongitude());
        addressResponse.setLatitude(address.getLatitude());
        addressResponse.setFirstLine(address.getFirstLine());
        addressResponse.setSecondLine(address.getSecondLine());
        addressResponse.setIndex(address.getIndex());

        return addressResponse;
    }
}
