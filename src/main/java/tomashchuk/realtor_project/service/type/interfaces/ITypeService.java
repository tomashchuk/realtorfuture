package tomashchuk.realtor_project.service.type.interfaces;

import tomashchuk.realtor_project.entity.Type;
import tomashchuk.realtor_project.dto.TypeResponse;
import tomashchuk.realtor_project.dto.TypeRequest;

import java.util.List;

public interface ITypeService {
    List<TypeResponse> getAll();
    TypeResponse getById(Long id);
    TypeResponse create(TypeRequest type);
    TypeResponse update(Long id, Type type);
    void delete(Long id);
}
