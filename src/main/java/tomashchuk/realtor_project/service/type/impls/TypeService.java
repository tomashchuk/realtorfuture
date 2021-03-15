package tomashchuk.realtor_project.service.type.impls;

import tomashchuk.realtor_project.entity.Type;
import tomashchuk.realtor_project.repository.TypeRepository;
import tomashchuk.realtor_project.service.type.interfaces.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TypeService implements ITypeService {
    @Autowired
    private TypeRepository typeRepository;
    @Override
    public List<Type> getAll() {
        return typeRepository.findAll();
    }

    @Override
    public Type getById(Long id) {
        Optional<Type> result = typeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Type create(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type update(Long id, Type type) {
        return typeRepository.save(type);
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }
}