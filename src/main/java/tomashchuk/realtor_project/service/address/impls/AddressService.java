package tomashchuk.realtor_project.service.address.impls;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tomashchuk.realtor_project.dto.AddressRequest;
import tomashchuk.realtor_project.dto.AddressResponse;
import tomashchuk.realtor_project.entity.Address;
import tomashchuk.realtor_project.repository.AddressRepository;
import tomashchuk.realtor_project.service.address.interfaces.IAddressService;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AddressService implements IAddressService {
    private final AddressRepository addressRepository;
    @Override
    public List<AddressResponse> getAll() {
        var addresses = addressRepository.findAll();
        return addresses.stream().map(AddressResponse::mapToAddressResponse).collect(Collectors.toList());
    }

    @Override
    public AddressResponse getById(Long id) {
        Optional<Address> result = addressRepository.findById(id);
        if (result.isPresent()) {
            return AddressResponse.mapToAddressResponse(result.get());
        } else {
            return null;
        }
    }
    @Override
    public AddressResponse create(AddressRequest address) {
        var newAddress = Address.builder()
                .id(new Random().nextLong())
                .longitude(address.getLongitude())
                .latitude(address.getLatitude())
                .firstLine(address.getFirstLine())
                .secondLine(address.getSecondLine())
                .index(address.getIndex())
                .build();

        return AddressResponse.mapToAddressResponse(addressRepository.save(newAddress));
    }

    @Override
    public AddressResponse update(Long id, Address address) {
        return AddressResponse.mapToAddressResponse(addressRepository.save(address));
    }

    @Override
    public void delete(Long id) {
        addressRepository.deleteById(id);
    }
}
