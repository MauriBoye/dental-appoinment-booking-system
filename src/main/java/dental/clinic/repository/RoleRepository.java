package dental.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import dental.clinic.entities.ERole;
import dental.clinic.entities.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);

}
