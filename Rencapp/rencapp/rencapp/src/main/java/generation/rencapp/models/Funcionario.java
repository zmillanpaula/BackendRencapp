package generation.rencapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "funcionarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String departamento;

    /***************RELACIONES**********************/

    //co relacionar el metodo para el FUNCIONARIO, cascade se superpone en accion individual


    @ManyToMany(mappedBy= "funcionarios")
    private List<Agendamiento> agendamientos;

    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Horario> horarios;



    //atributos de auditoría (creación y actualización de objetos)
    //para saber en que momento llego/auditoria

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    //para actualizar
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
