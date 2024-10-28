package generation.rencapp.repositories;

import generation.rencapp.models.Agendamiento;
import generation.rencapp.models.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository

public interface AgendamientoRepository extends JpaRepository<Agendamiento, Long> {

    boolean existsByFechaHoraAndUsuarioId(LocalDateTime fechaHora, Long usuarioId);

    List<Agendamiento> findAllByUsuarioIdAndUsuarioTipo(Long usuarioId, TipoUsuario tipo);

    List<Agendamiento> findAllByTramiteId(Long tramiteId);




}

