package generation.rencapp.services;

import generation.rencapp.models.Tramite;
import generation.rencapp.repositories.TramiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TramiteServiceImpl implements TramiteService  {

    @Autowired
    private TramiteRepository tramiteRepository;

    @Override
    public Tramite findById(Long id) {
        return tramiteRepository.findById(id).get();
    }

    @Override
    public List<Tramite> findAllTramite() {
        return tramiteRepository.findAll();
    }

    @Override
    public Tramite saveTramite(Tramite nuevoTramite) {
        return tramiteRepository.save(nuevoTramite);
    }
}
