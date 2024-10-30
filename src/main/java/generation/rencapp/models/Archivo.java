package generation.rencapp.models;

import jakarta.persistence.*;
import lombok.*;

//agregar relaciones con importaciones
//las arrobas
@Entity
@Table(name = "archivos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Archivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String link;



    /******************* RELACIONES ************/

  /*  @OneToOne
    @JoinColumn(name ="archivo_id", nullable = false)
    private Archivo archivo;

*/
}
