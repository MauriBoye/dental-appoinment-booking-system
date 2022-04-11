package dental.clinic.repository;

import dental.clinic.entities.Adress;
import dental.clinic.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdressRepository extends JpaRepository<Adress, Integer> {
}
