package generation.rencapp.services;

import generation.rencapp.models.Agendamiento;

import java.time.LocalDate;
import java.time.LocalTime;

public interface AgendamientoService {

    Agendamiento agendar(Long funcionarioId, Long vecinoId, LocalDate fecha, LocalTime hora);


}
