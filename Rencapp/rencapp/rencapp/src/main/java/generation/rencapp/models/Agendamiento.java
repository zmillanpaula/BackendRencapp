package generation.rencapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import generation.rencapp.models.Vecino;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//Anotaciones
@Entity
@Table(name = "agendamientos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Agendamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate fecha;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private estadoCita estado;

    private enum estadoCita {
        AGENDADA,
        CANCELADA
    }

        /***************RELACIONES ********************/
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vecino_id", nullable = false)
    private Vecino vecino;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "funcionario_id", nullable = false)
    private Funcionario funcionario;

    //manytomany
    @ManyToMany
    @JoinTable(name = "agendamientos_funcionarios", joinColumns = @JoinColumn(name = "funcionario_id"), inverseJoinColumns = @JoinColumn(name = "agendamiento_id"))
    private List<Funcionario> funcionarios;


}