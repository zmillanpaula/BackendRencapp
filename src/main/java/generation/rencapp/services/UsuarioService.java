package generation.rencapp.services;

import generation.rencapp.models.Usuario;
import org.springframework.stereotype.Service;

@Service
public interface UsuarioService {

    public Usuario findById(Long id);
    public Usuario saveUsuario(Usuario usuarioNuevo);

}
