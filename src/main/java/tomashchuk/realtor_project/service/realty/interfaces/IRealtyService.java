package tomashchuk.realtor_project.service.realty.interfaces;

import tomashchuk.realtor_project.dto.RealtyRequest;
import tomashchuk.realtor_project.dto.RealtyResponse;
import tomashchuk.realtor_project.entity.Realty;

import java.util.List;

public interface IRealtyService {
    List<RealtyResponse> getAll();
    List<RealtyResponse> getRealtiesByTypeId(Long id);
    RealtyResponse getById(Long id);
    RealtyResponse create(RealtyRequest realty);
    RealtyResponse update(Long id, Realty realty);
    void delete(Long id);
}
