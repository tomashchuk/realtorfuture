package tomashchuk.realtor_project.repository;

import tomashchuk.realtor_project.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TypeRepository extends JpaRepository<Type, Long> {
}