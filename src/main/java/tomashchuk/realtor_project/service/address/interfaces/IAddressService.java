package tomashchuk.realtor_project.service.address.interfaces;

import tomashchuk.realtor_project.dto.AddressRequest;
import tomashchuk.realtor_project.dto.AddressResponse;
import tomashchuk.realtor_project.entity.Address;

import java.util.List;

public interface IAddressService {
    List<AddressResponse> getAll();
    AddressResponse getById(Long id);
    AddressResponse create(AddressRequest address);
    AddressResponse update(Long id, Address address);
    void delete(Long id);
}
