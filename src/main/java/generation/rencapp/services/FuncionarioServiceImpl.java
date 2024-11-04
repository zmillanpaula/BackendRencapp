package generation.rencapp.services;

import generation.rencapp.models.Funcionario;
import generation.rencapp.repositories.FuncionarioRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    @Transactional
    @AllArgsConstructor

    public class FuncionarioServiceImpl implements FuncionarioService {
    //Inyeccion de depencias
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Override
    public List<Funcionario> findAll() {
        return funcionarioRepository.findAll();
    }


    @Override
    public Funcionario findById(Long id) {
        //Llama al repository y al método para buscar por ID
        return funcionarioRepository.findById(id).get();
    }

    @Transactional
    public Funcionario saveFuncionario(Funcionario nuevoFuncionario) {
        return funcionarioRepository.save(nuevoFuncionario);
    }

    //metodo para mostrar agendamientos con tipo de tramite
}
