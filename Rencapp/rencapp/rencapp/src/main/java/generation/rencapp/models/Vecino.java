package generation.rencapp.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@DiscriminatorValue("VECINO")
//anotaciones de acceso a atributos (getter y setter)
//constructor vacío y constructor lleno
//generar entidad vecino
public class Vecino  extends Usuario{

    private String motivoDeConsulta;

    //atributos de auditoría (creación y actualización de objetos)
    //para saber en que momento llego/auditoria
    @CreationTimestamp
    private LocalDateTime createdAt;
    //para actualizar
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /***************RELACIONES**********************/


    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
