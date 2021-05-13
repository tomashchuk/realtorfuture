package tomashchuk.realtor_project.mapper;

import tomashchuk.realtor_project.dto.TypeRequest;
import tomashchuk.realtor_project.entity.Type;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Random;


@Component
public class TypeMapper {
    public Type fromRequest(TypeRequest request) {
        return Type.builder()
                .id(new Random().nextLong())
                .description(request.getDescription())
                .name(request.getName())
                .realties(new HashSet<>())
                .build();
    }
}

