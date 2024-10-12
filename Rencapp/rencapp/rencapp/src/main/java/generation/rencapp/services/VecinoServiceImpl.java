package generation.rencapp.services;

import generation.rencapp.models.Vecino;
import generation.rencapp.repositories.VecinoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VecinoServiceImpl implements VecinoService {
//Inyeccion de dependencias
//agregar metodos
    @Autowired
    private VecinoRepository vecinoRepository;

    @Override
    public List<Vecino> findAll(){
    }

    @Override
    public Vecino findById(Long id) {
        //Llama al repository y al método para buscar por ID
        return VecinoService.findById(id).get();
    }

    @Transactional
    public  Vecino saveVecino(Vecino vecino){
        return VecinoService.save(vecino);
    }



}

