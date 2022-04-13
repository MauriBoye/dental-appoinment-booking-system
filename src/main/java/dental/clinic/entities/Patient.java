package dental.clinic.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "patients")
public class Patient {

    @Id //Indicamos que es un ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //La manera que queremos generar el ID
    @Column(name = "id") //Como quiero que se llame la columna en la DB
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dni")
    private String dni;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "entryDate")
    private LocalDate entryDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "adress_id",
            referencedColumnName = "id")
    private Adress adress;

    // Indicar que el atributo “patient” del lado de la clase "appointment" es quien establece la relación
    @OneToMany(mappedBy = "patient")
    @JsonIgnore //Si este objeto viaja en formato JSON, podría entrar en un bucle infinito
    private Set<Appointment> appointments;

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", entryDate=" + entryDate +
                ", adress=" + adress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getId(), patient.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
