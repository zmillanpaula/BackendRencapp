package generation.rencapp.services;

import generation.rencapp.models.Horario;
import generation.rencapp.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository horarioRepository;


    //es conveniente inyectar la java class o la interfaz?
    @Autowired
    private FuncionarioServiceImpl funcionarioServiceImpl;

    //buscar horario por id

    public Horario findById(Long id) {
        return horarioRepository.findById(id).get();
    }

    //buscar todos los horarios

    public List<Horario> findAll() {
        return horarioRepository.findAll();
    }

    //guardar un horario

    public Horario saveHorario(Horario horarioNuevo) {
        return horarioRepository.save(horarioNuevo);
    }

    //eliminar un horario

    public void deleteHorarioById(Long id) {
        horarioRepository.deleteById(id);
    }

    //encontrar un horario a partir del atributo estado

    public List<Horario> findHorarioByEstado(String estado) {
        return horarioRepository.findByEstado(estado);
    }

    //

    public List<LocalTime> obtenerIntervalosDeUnaHora(Long funcionarioId, LocalDateTime fechaHora) {
        //horario creado se guarda en una variable
        LocalDateTime fecha = fechaHora.toLocalDate().atStartOfDay();
        Horario horario = horarioRepository.findByFuncionarioIdAndFecha(funcionarioId,fecha);

        if(horario == null) {
            return new ArrayList<>();
        }

        List<LocalTime> intervalosUnaHora = generarIntervalos(horario.getHoraInicio(), horario.getHoraFin());

        return intervalosUnaHora;
    }

    public List<LocalTime> generarIntervalos(LocalTime horaInicio, LocalTime horaFin) {
        List<LocalTime> intervalos = new ArrayList<>();

        LocalTime horaActual = horaInicio;

        while (horaActual.isBefore(horaFin)) {
            intervalos.add(horaActual);
            horaActual = horaActual.plusHours(1);
        }

        return intervalos;
    }

    public boolean validarAgendamientoDentroDelHorario(Long funcionarioId, LocalDateTime horaFecha) {
        List<LocalTime> intervalosDisponibles = obtenerIntervalosDeUnaHora(funcionarioId, horaFecha);
        return intervalosDisponibles.contains(horaFecha);
    }


}
