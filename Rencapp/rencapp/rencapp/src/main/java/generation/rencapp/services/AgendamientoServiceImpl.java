package generation.rencapp.services;

import generation.rencapp.repositories.AgendamientoRepository;
import generation.rencapp.repositories.VecinoRepository;
import generation.rencapp.models.Agendamiento;
import generation.rencapp.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

//Anotaciones
@Service
public class AgendamientoServiceImpl implements AgendamientoService{

    //Inyección de dependencias
    @Autowired
    private AgendamientoRepository agendamientoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private VecinoRepository vecinoRepository;

    @Autowired
    private HorarioServiceImpl horarioServiceImpl;


    //Método para agendar cita
    @Override
    public Agendamiento agendar(Long funcionarioId, Long vecinoId, LocalDate fecha, LocalTime hora) {
        //1-) Validar si la hora esta contenida dentro del intervalo y guardamos el resultado en una variable
        boolean esValido = horarioServiceImpl.validarAgendamientoDentroDelHorario(funcionarioId, fecha, hora);

        if (!esValido) {
            throw new IllegalArgumentException("La hora indicada no está disponible");
        }

        //2-) Validar que no exista otra cita con el doctor a la misma hora
        boolean existeAgendamiento = agendamientoRepository.existsByFuncionarioIdAndFechaAndHora(funcionarioId, fecha, hora);

        if (existeAgendamiento) {
            throw new IllegalArgumentException("La hora indicada ya está ocupada");
        }

        //3-) Generar la cita y guardar
        Agendamiento nuevoAgendamiento = Agendamiento.builder()
                .vecino(vecinoRepository.findById(vecinoId).get())
                .funcionario(funcionarioRepository.findById(funcionarioId).get())
                /*.fechaHora(fechaHora)     preguntar*/
                .build();

        agendamientoRepository.save(nuevoAgendamiento);

        return nuevoAgendamiento;
    }

   // public void Agendamiento eliminarAgendamiento() {}


}