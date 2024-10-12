package generation.rencapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table (name = "vecinos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
//anotaciones de acceso a atributos (getter y setter)
//constructor vacío y constructor lleno
//generar entidad vecino
public class Vecino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String motivoDeConsulta;

    //atributos de auditoría (creación y actualización de objetos)
    //para saber en que momento llego/auditoria
    @CreationTimestamp
    private LocalDateTime createdAt;
    //para actualizar
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /***************RELACIONES**********************/

    //relacion con usuario

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Vecino vecino;


    //co relacionar el metodo para el vecino, cascade se superpone en accion individual
    @OneToMany(mappedBy = "vecino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agendamiento> agendamientos;

}
