package tomashchuk.realtor_project.service.address.impls;

import org.springframework.beans.factory.annotation.Autowired;
import tomashchuk.realtor_project.entity.Address;
import tomashchuk.realtor_project.repository.AddressRepository;
import tomashchuk.realtor_project.service.address.interfaces.IAddressService;

import java.util.List;
import java.util.Optional;

public class AddressService implements IAddressService {
    @Autowired
    private AddressRepository addressRepository;
    @Override
    public List<Address> getAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address getById(Long id) {
        Optional<Address> result = addressRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
