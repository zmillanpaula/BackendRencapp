package generation.rencapp.repositories;

import generation.rencapp.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HorarioRepository extends JpaRepository<Horario, Long> {

    List<Horario> findByEstado(String estado);

    List<Horario> findByFuncionarioId(Long id);

    Horario findByFuncionarioIdAndFecha(Long id, LocalDate fecha);


}
