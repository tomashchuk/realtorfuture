package tomashchuk.realtor_project.service.realty.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tomashchuk.realtor_project.dto.RealtyRequest;
import tomashchuk.realtor_project.dto.RealtyResponse;
import tomashchuk.realtor_project.dto.TypeResponse;
import tomashchuk.realtor_project.entity.Realty;
import tomashchuk.realtor_project.entity.Type;
import tomashchuk.realtor_project.repository.RealtyRepository;
import tomashchuk.realtor_project.service.realty.interfaces.IRealtyService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class RealtyService implements IRealtyService {
    private final RealtyRepository realtyRepository;
    @Override
    public List<RealtyResponse> getAll() {
        var realties = realtyRepository.findAll();
        return realties.stream().map(RealtyResponse::mapToRealtyResponse).collect(Collectors.toList());
    }

    @Override
    public List<RealtyResponse> getRealtiesByTypeId(Long id) {
        var rooms = realtyRepository.findRealtiesByType_Id(id);
        return rooms.stream().map(RealtyResponse::mapToRealtyResponse).collect(Collectors.toList());
    }

    @Override
    public RealtyResponse getById(Long id) {
        Optional<Realty> result = realtyRepository.findById(id);
        if (result.isPresent()) {
            return RealtyResponse.mapToRealtyResponse(result.get());
        } else {
            return null;
        }
    }

    @Override
    public RealtyResponse create(RealtyRequest realty) {
        var newRealty = Realty.builder()
                .id(new Random().nextLong())
                .description(realty.getDescription())
                .name(realty.getName())
                .build();

        return RealtyResponse.mapToRealtyResponse(realtyRepository.save(newRealty));
    }

    @Override
    public RealtyResponse update(Long id, Realty realty) {
        return RealtyResponse.mapToRealtyResponse(realtyRepository.save(realty));
    }

    @Override
    public void delete(Long id) {
        realtyRepository.deleteById(id);
    }
}
