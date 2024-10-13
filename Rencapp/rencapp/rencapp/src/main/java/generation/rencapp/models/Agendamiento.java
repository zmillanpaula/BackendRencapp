package generation.rencapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private estadoAgendamiento estado;

    private enum estadoAgendamiento {
        AGENDADA,
        CANCELADA
    }

        /***************RELACIONES ********************/
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "vecino_id", nullable = false)
    private Vecino vecino;

    @ManyToOne
    @JoinColumn(name = "tramite_id", nullable = false)
    private Tramite tramite;

    @ManyToOne
    @JoinColumn(name = "agendamientos_funcionarios", nullable = false)
    private Tramite funcionario;

    //manytomany
   // @ManyToMany
   // @JoinTable(name = "agendamientos_funcionarios", joinColumns = @JoinColumn(name = "agendamiento_id"), inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
   // private List<Funcionario> funcionarios;


}