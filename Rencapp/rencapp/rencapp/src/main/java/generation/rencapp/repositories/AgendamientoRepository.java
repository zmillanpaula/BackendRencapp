package generation.rencapp.repositories;

import generation.rencapp.models.Agendamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendamientoRepository extends JpaRepository<Agendamiento, Long> {
}
