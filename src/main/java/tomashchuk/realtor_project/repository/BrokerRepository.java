package tomashchuk.realtor_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomashchuk.realtor_project.entity.Broker;

public interface BrokerRepository extends JpaRepository<Broker, Long> {
}
