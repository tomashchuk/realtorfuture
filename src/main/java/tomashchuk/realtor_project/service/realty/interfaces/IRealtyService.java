package tomashchuk.realtor_project.service.realty.interfaces;

import tomashchuk.realtor_project.entity.Realty;

import java.util.List;

public interface IRealtyService {
    List<Realty> getAll();
    Realty getById(Long id);
    Realty create(Realty realty);
    Realty update(Long id, Realty realty);
    void delete(Long id);
}
