package generation.rencapp.services;

import generation.rencapp.models.Usuario;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UsuarioService {

    Usuario guardarUsuario(Usuario usuarioNuevo);

}