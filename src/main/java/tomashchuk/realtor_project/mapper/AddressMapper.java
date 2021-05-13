package tomashchuk.realtor_project.mapper;

import tomashchuk.realtor_project.dto.AddressRequest;
import tomashchuk.realtor_project.entity.Address;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;


@Component
public class AddressMapper {
    public Address fromRequest(AddressRequest request) {
        return Address.builder()
                .id(new Random().nextLong())
                .longitude(request.getLongitude())
                .latitude(request.getLatitude())
                .firstLine(request.getFirstLine())
                .secondLine(request.getSecondLine())
                .index(request.getIndex())
                .realties(new HashSet<>())
                .build();
    }
}
