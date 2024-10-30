package generation.rencapp.services;

import generation.rencapp.models.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;

public interface FuncionarioService {

        //Declaración de métodos
        Funcionario findById(Long id);

        List<Funcionario> findAll();

}
