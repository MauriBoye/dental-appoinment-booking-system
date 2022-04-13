package dental.clinic.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Data

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id //Indicamos que es un ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) //La manera que queremos generar el ID
    @Column(name = "id") //Como quiero que se llame la columna en la DB
    private Integer id;

    @JsonFormat(pattern="yyyy-MM-dd")
    @Column(name = "date")
    private LocalDate date;

    @JsonFormat(pattern="HH:mm:ss")
    @Column(name = "time")
    private LocalTime time;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", dentist=" + dentist +
                ", patient=" + patient +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Appointment)) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
