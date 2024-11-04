package generation.rencapp.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@DiscriminatorValue("VECINO")
//anotaciones de acceso a atributos (getter y setter)
//constructor vacío y constructor lleno
//generar entidad vecino
public class Vecino  extends Usuario{

    @Column (name = "direccion")

    private String direccion;

    private int numeroTelefono;

    @Column()
    private String numeroDeDocumento;

    @Column ()//nullable=false
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;

    private String motivoDeConsulta;

    //atributos de auditoría (creación y actualización de objetos)
    //para saber en que momento llego/auditoria
    @CreationTimestamp
    private LocalDateTime createdAt;
    //para actualizar
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    /***************RELACIONES**********************/

}
