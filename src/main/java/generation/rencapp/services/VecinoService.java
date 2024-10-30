package generation.rencapp.services;

import generation.rencapp.models.Vecino;

import java.util.List;

public interface VecinoService {

    Vecino findById(Long id);

    List<Vecino> findAllVecino();

    Vecino saveVecino(Vecino nuevoVecino);
}
