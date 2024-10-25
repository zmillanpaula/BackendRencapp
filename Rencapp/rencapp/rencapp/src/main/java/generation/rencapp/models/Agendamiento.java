package generation.rencapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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


    @JsonFormat(pattern = "YYYY-M-DD-HH:mm")
    private LocalDateTime fechaHora;

    private String motivo;

    @Enumerated(EnumType.STRING)
    private estadoAgendamiento estado;

    public enum estadoAgendamiento {
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
    @JoinColumn(name = "tramite_id", nullable = false)
    private Tramite tramite;

    @ManyToOne
    @JoinColumn(name = "agendamientos_funcionarios", nullable = false)
    private Funcionario funcionario;

    //manytomany
   // @ManyToMany
   // @JoinTable(name = "agendamientos_funcionarios", joinColumns = @JoinColumn(name = "agendamiento_id"), inverseJoinColumns = @JoinColumn(name = "funcionario_id"))
   // private List<Funcionario> funcionarios;


}