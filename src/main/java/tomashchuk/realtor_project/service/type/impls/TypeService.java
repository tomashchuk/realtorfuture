package tomashchuk.realtor_project.service.type.impls;

import tomashchuk.realtor_project.entity.Type;
import tomashchuk.realtor_project.repository.TypeRepository;
import tomashchuk.realtor_project.dto.TypeRequest;
import tomashchuk.realtor_project.dto.TypeResponse;
import tomashchuk.realtor_project.service.type.interfaces.ITypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TypeService implements ITypeService {
    private final TypeRepository typeRepository;
    @Override
    public List<TypeResponse> getAll() {
        var types = typeRepository.findAll();
        return types.stream().map(TypeResponse::mapToTypeResponse).collect(Collectors.toList());
    }

    @Override
    public TypeResponse getById(Long id) {
        Optional<Type> result = typeRepository.findById(id);
        if (result.isPresent()) {
            return TypeResponse.mapToTypeResponse(result.get());
        } else {
            return null;
        }
    }

    @Override
    public TypeResponse create(TypeRequest type) {
        var newType = Type.builder()
                .id(new Random().nextLong())
                .description(type.getDescription())
                .name(type.getName())
                .realties(new HashSet<>())
                .build();

        return TypeResponse.mapToTypeResponse(typeRepository.save(newType));
    }

    @Override
    public TypeResponse update(Long id, Type type) {
        return TypeResponse.mapToTypeResponse(typeRepository.save(type));
    }

    @Override
    public void delete(Long id) {
        typeRepository.deleteById(id);
    }
}