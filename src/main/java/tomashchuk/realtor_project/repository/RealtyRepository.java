package tomashchuk.realtor_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomashchuk.realtor_project.entity.Realty;

public interface RealtyRepository extends JpaRepository<Realty, Long> {
}
