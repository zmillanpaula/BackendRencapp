package generation.rencapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString


public class Usuario {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;


        private String nombre;

        private String apellido;

        private int numeroTelefono;

        private String direccion;


        @Column(nullable = false, unique = true)//Restricciones para la columna, no permitir null y sólo registros únicos
        private String email;

        @Column(nullable = false)
        private String password;

        @Enumerated(EnumType.STRING)//Anotación para indicar que el valor del atributo va a tomarse de una enumeración
        @Column(nullable = false)
        private TipoUsuario tipoUsuario;

        //Atributos de auditoría, me permiten conocer la fecha de creación y de la última edición
        @CreationTimestamp//Anotación para generar el almacenamiento de la fecha de creación
        private LocalDateTime createdAt;

        @UpdateTimestamp//Anotación para generar el almacenamiento de la fecha de actualización
        private LocalDateTime updatedAt;

        /******ESPACIO PARA OTROS ATRIBUTOS*******/
        //Relaciones en Java se indican mediante anotaciones para que Hibernate cree las llaves foráneas en las tablas correspondientes



        /*****************************************/

}


