package tomashchuk.realtor_project.service.realty.impls;

import org.springframework.beans.factory.annotation.Autowired;
import tomashchuk.realtor_project.entity.Realty;
import tomashchuk.realtor_project.repository.RealtyRepository;
import tomashchuk.realtor_project.service.realty.interfaces.IRealtyService;

import java.util.List;
import java.util.Optional;

public class RealtyService implements IRealtyService {
    @Autowired
    private RealtyRepository realtyRepository;
    @Override
    public List<Realty> getAll() {
        return realtyRepository.findAll();
    }

    @Override
    public Realty getById(Long id) {
        Optional<Realty> result = realtyRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Realty create(Realty realty) {
        return realtyRepository.save(realty);
    }

    @Override
    public Realty update(Long id, Realty realty) {
        return realtyRepository.save(realty);
    }

    @Override
    public void delete(Long id) {
        realtyRepository.deleteById(id);
    }
}
