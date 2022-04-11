package dental.clinic.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "adress")
public class Adress {

    @Id //Indicamos que es un ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //La manera que queremos generar el ID
    @Column(name = "id") //Como quiero que se llame la columna en la DB
    private Integer id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return Objects.equals(getId(), adress.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
