package tomashchuk.realtor_project.mapper;

import org.springframework.stereotype.Component;
import tomashchuk.realtor_project.dto.RealtyRequest;
import tomashchuk.realtor_project.entity.Realty;

import java.util.Random;


@Component
public class RealtyMapper {
    public Realty fromRequest(RealtyRequest request) {
        return Realty.builder()
                .id(new Random().nextLong())
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .is_sold(request.getIs_sold())
//                .type(request.getType())
//                .address(request.getAddress())
//                .broker(request.getBroker())
                .build();
    }
}
