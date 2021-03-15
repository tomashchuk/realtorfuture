package tomashchuk.realtor_project.service.address.interfaces;

import tomashchuk.realtor_project.entity.Address;

import java.util.List;

public interface IAddressService {
    List<Address> getAll();
    Address getById(Long id);
    Address create(Address broker);
    Address update(Long id, Address broker);
    void delete(Long id);
}
