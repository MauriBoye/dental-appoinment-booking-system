package dental.clinic.repository;

import dental.clinic.entities.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JPA me permite relacionar el modelo orientado a objetos con el
//modelo relacional de las bases de datos
@Repository //Especifica que es repositorio
public interface IDentistRepository extends JpaRepository<Dentist, Integer> {

}
