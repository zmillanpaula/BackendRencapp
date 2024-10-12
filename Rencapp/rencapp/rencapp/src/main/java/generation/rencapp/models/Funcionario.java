package generation.rencapp.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String departamento;

    /***************RELACIONES**********************/

    //co relacionar el metodo para el FUNCIONARIO, cascade se superpone en accion individual

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Funcionario funcionario;

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
