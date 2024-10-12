package generation.rencapp.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

public class Tramite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nombre;

    @ManyToMany(mappedBy = "tramites")
    private List<Funcionario> funcionarios;

}
