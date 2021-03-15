package tomashchuk.realtor_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomashchuk.realtor_project.entity.Client;

public interface ClientRepository  extends JpaRepository<Client, Long> {
}
