package tomashchuk.realtor_project.dto;

import lombok.Data;
import tomashchuk.realtor_project.entity.Type;

@Data
public class TypeResponse {
    private Long id;
    private String name;
    private String description;

    public static TypeResponse mapToTypeResponse(Type type) {
        TypeResponse typeResponse = new TypeResponse();

        typeResponse.setId(type.getId());
        typeResponse.setDescription(type.getDescription());
        typeResponse.setName(type.getName());

        return typeResponse;
    }
}
