package tomashchuk.realtor_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tomashchuk.realtor_project.entity.Realty;

import java.util.List;

public interface RealtyRepository extends JpaRepository<Realty, Long> {
    List<Realty> findRealtiesByType_Id(Long id);
}
