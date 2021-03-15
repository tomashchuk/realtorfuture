package tomashchuk.realtor_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomashchuk.realtor_project.entity.Address;

public interface AddressRepository  extends JpaRepository<Address, Long> {
}
