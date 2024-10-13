package generation.rencapp.repositories;

import generation.rencapp.models.Agendamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository

public interface AgendamientoRepository extends JpaRepository<Agendamiento, Long> {

    boolean existsByFuncionarioIdAndFechaAndHora(Long funcionarioId, LocalDate fecha, LocalTime hora);
}

