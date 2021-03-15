package tomashchuk.realtor_project.service.type.interfaces;

import tomashchuk.realtor_project.entity.Type;

import java.util.List;

public interface ITypeService {
    List<Type> getAll();
    Type getById(Long id);
    Type create(Type type);
    Type update(Long id, Type type);
    void delete(Long id);
}
