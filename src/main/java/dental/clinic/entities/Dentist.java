package dental.clinic.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Objects;


// Lombok
@Data //Generar constructor con todos los atributos, constructor vacio, los getter y setter

@Entity //Le decimos que va a ser una entidad
@Table(name = "dentists") //Como quiero que se llame la tabla en la DB
public class Dentist {

    @Id //Indicamos que es un ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //La manera que queremos generar el ID
    @Column(name = "id") //Como quiero que se llame la columna en la DB
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "registration")
    private String registration;

    //Generamos toString
    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", registration='" + registration + '\'' +
                '}';
    }

    //Generamos equals por el ID para comparar objetos
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dentist)) return false;
        Dentist dentist = (Dentist) o;
        return Objects.equals(getId(), dentist.getId());
    }

    //Generamos hash code por el ID para
    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
