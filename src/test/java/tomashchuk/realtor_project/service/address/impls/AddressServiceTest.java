package tomashchuk.realtor_project.service.address.impls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tomashchuk.realtor_project.entity.Address;
import tomashchuk.realtor_project.mapper.AddressMapper;
import tomashchuk.realtor_project.repository.AddressRepository;
import tomashchuk.realtor_project.stubs.AddressStub;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    private AddressService service;
    @Mock
    private AddressRepository addressRepository;
    @Mock
    private AddressMapper addressMapper;

    @BeforeEach
    void setup() {
        service = new AddressService(addressRepository, addressMapper);
    }

    @Test
    void getSuccessful() {
        List<Address> list = new ArrayList<Address>();
        var address = AddressStub.getRandomAddress();
        list.add(address);
        list.add(address);
        list.add(address);

        when(addressRepository.findAll()).thenReturn(list);
        var getAll = service.getAll();
        assertEquals(list.size(), getAll.size());
    }

    @Test
    void getSuccessfulById() {
        var address = AddressStub.getRandomAddress();
        when(addressRepository.findById(Mockito.any())).thenReturn(Optional.of(address));
        var byId = service.getById(AddressStub.ID);

        assertAll(() -> assertEquals(byId.getId(), address.getId()),
                () -> assertEquals(byId.getLongitude(), address.getLongitude()),
                () -> assertEquals(byId.getLatitude(), address.getLatitude()),
                () -> assertEquals(byId.getFirstLine(), address.getFirstLine()),
                () -> assertEquals(byId.getSecondLine(), address.getSecondLine()),
                () -> assertEquals(byId.getIndex(), address.getIndex())
        );

    }

    @Test
    void getFailedById() {
        when(addressRepository.findById(Mockito.any())).thenReturn(Optional.empty());
        var e = assertThrows(NoSuchElementException.class, () -> service.getById(AddressStub.ID));
        assertEquals(e.getMessage(), "No value present");
    }

    @Test
    void createSuccessful() {
        var captor = ArgumentCaptor.forClass(Address.class);
        var address = AddressStub.getRandomAddress();
        when(addressMapper.fromRequest(Mockito.any())).thenReturn(address);
        when(addressRepository.save(Mockito.any())).thenReturn(AddressStub.getRandomAddress());
        var result = service.create(AddressStub.getAddressRequest());
        Mockito.verify(addressRepository, atLeast(1)).save(captor.capture());
        assertEquals(address, captor.getValue());
        assertEquals(address.getLongitude(), result.getLongitude());
        assertEquals(address.getId(), result.getId());
        assertEquals(address.getLatitude(), result.getLatitude());
        assertEquals(address.getIndex(), result.getIndex());
    }

    @Test
    void updateSuccessful() {
        var captor = ArgumentCaptor.forClass(Address.class);
        var address = AddressStub.getRandomAddress();
        when(addressRepository.save(Mockito.any())).thenReturn(AddressStub.getRandomAddress());
        var result = service.update(AddressStub.ID, AddressStub.getRandomAddress());
        Mockito.verify(addressRepository, atLeast(1)).save(captor.capture());
        assertEquals(address, captor.getValue());
        assertEquals(address.getFirstLine(), result.getFirstLine());
        assertEquals(address.getIndex(), result.getIndex());
    }

    @Test
    void deleteSuccessful() {
        service.delete(AddressStub.ID);
        var captor = ArgumentCaptor.forClass(Long.class);
        Mockito.verify(addressRepository, atLeast(1)).deleteById(captor.capture());
        assertEquals(AddressStub.ID, captor.getValue());
    }
}
