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

    private String nombre;

    @ManyToMany(mappedBy = "tramites")
    private List<Funcionario> funcionarios;

    @OneToMany(mappedBy = "tramite", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Agendamiento> agendamientos;


}
