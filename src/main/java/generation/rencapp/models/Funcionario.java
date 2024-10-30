package generation.rencapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("FUNCIONARIO")

public class Funcionario extends Usuario{

    private String departamento;

    private Boolean atencionOnline;

    /***************RELACIONES**********************/

    //co relacionar el metodo para el FUNCIONARIO, cascade se superpone en accion individual


    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    @ManyToMany
    @JoinTable(//Al tener una relacion de N a N, indicamos nombre de la tabla relacional
            name = "tramites_funcionarios",
            joinColumns = @JoinColumn(name = "funcionario_id"),//Nombre de la columna que lleva la llave foránea
            inverseJoinColumns = @JoinColumn(name = "tramite_id"))//Nombre de la columna de  la otra entidad
    private List<Tramite> tramites;




    //atributos de auditoría (creación y actualización de objetos)
    //para saber en que momento llego/auditoria

    @CreationTimestamp
    private LocalDateTime createdAt;

    //para actualizar
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
