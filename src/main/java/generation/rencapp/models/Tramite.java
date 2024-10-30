package generation.rencapp.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
@Entity
@Table(name = "tramites")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;
    private Boolean agendamiento;
    private Boolean pagoAsociado;
    private Boolean terminosYCondiciones;
    private Boolean cargaDeArchivo;

    @ManyToMany(mappedBy = "tramites")
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "tramite", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agendamiento> agendamientos;


}
