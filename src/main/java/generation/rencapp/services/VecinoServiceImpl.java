package generation.rencapp.services;

import generation.rencapp.models.Vecino;
import generation.rencapp.repositories.VecinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class VecinoServiceImpl implements VecinoService {
    //Inyeccion de dependencias
//agregar metodos
    @Autowired
    private VecinoRepository vecinoRepository;

    @Override
    public List<Vecino> findAllVecino(){
        return vecinoRepository.findAll();
    }

    @Override
    public Vecino findById(Long id) {
        //Llama al repository y al método para buscar por ID
        return vecinoRepository.findById(id).get();
    }

    @Transactional
    public Vecino saveVecino(Vecino nuevoVecino){
        return vecinoRepository.save(nuevoVecino);
    }

    //metodo para mostrar agendamientos



}


