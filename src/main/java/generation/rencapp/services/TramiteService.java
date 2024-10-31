package generation.rencapp.services;
import generation.rencapp.models.Tramite;
import java.util.List;

public interface TramiteService {

    Tramite findById(Long id);

    List<Tramite> findAllTramite();

    Tramite saveTramite(Tramite nuevoTramite);


}
