package tomashchuk.realtor_project.stubs;

import tomashchuk.realtor_project.dto.AddressRequest;
import tomashchuk.realtor_project.entity.Address;

import java.math.BigDecimal;
import java.util.HashSet;


public final class AddressStub {
    public static final Long ID = 1L;
    public static final BigDecimal LONGITUDE = new BigDecimal(1);
    public static final BigDecimal LATITUDE = new BigDecimal(1);
    public static final String FIRST_LINE = "firstLine";
    public static final String SECOND_LINE = "secondLine";
    public static final String INDEX = "58000";
    public static Address getRandomAddress() {
        return Address.builder()
                .id(ID)
                .longitude(LONGITUDE)
                .latitude(LATITUDE)
                .firstLine(FIRST_LINE)
                .secondLine(SECOND_LINE)
                .index(INDEX)
                .realties(new HashSet<>())
                .build();
    }
    public static AddressRequest getAddressRequest() {
        var addressRequest = new AddressRequest();
        addressRequest.setLongitude(LONGITUDE);
        addressRequest.setLatitude(LATITUDE);
        addressRequest.setFirstLine(FIRST_LINE);
        addressRequest.setSecondLine(SECOND_LINE);
        addressRequest.setIndex(INDEX);
        return addressRequest;
    }
}
