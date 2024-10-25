package generation.rencapp.services;

import generation.rencapp.models.Agendamiento;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface AgendamientoService {

    Agendamiento agendar(Long funcionarioId, Long vecinoId, LocalDate fecha, LocalTime hora);

    Agendamiento findById(Long agendamientoId);

    Agendamiento suspenderAgendamiento(Long agendamientoId);

    List<Agendamiento> agendamientosbyVecinoId(LocalDateTime fechaHora, Long vecinoId);

    List<Agendamiento> agendamientosbyTramiteId(LocalDateTime fechaHora , Long tramiteId);


}
