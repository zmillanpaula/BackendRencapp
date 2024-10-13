package generation.rencapp.services;

import generation.rencapp.models.Horario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface HorarioService {

    Horario findById(Long id);

    List<Horario> findAll();

    Horario saveHorario(Horario horarioNuevo);

    //los metodos void o boolean se dejan en una interfaz?

    List<Horario> findHorarioByEstado(String estado);

    List<LocalTime> obtenerIntervalosDeUnaHora(Long funcionarioId, LocalDate fecha);

    List<LocalTime> generarIntervalos(LocalTime horaInicio, LocalTime horaFin);



}
