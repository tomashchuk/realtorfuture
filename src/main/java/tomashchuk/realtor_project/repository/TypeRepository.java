package tomashchuk.realtor_project.repository;

import tomashchuk.realtor_project.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TypeRepository extends JpaRepository<Type, Long> {
    Optional<Type> findTypeByName(String name);
}