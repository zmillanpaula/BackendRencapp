package generation.rencapp.services;

import generation.rencapp.repositories.AgendamientoRepository;
import generation.rencapp.repositories.VecinoRepository;
import generation.rencapp.models.Agendamiento;
import generation.rencapp.repositories.AgendamientoRepository;
import generation.rencapp.repositories.FuncionarioRepository;
import generation.rencapp.repositories.VecinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

//Anotaciones
@Service
public class AgendamientoServiceImpl {

    //Inyección de dependencias
    @Autowired
    private AgendamientoRepository agendamientoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private VecinoRepository vecinoRepository;

    @Autowired
    private HorarioService horarioService;

    //Método para agendar cita
    public Agendamiento agendarCita(Long doctorId, Long pacienteId, LocalDate fecha, LocalTime hora) {
        //1-) Validar si la hora esta contenida dentro del intervalo y guardamos el resultado en una variable
        boolean esValida = horarioService.validarAgendamientoDentroDelHorario(Funcionario, fecha, hora);

        if (!esValida) {
            throw new IllegalArgumentException("La hora indicada no está disponible");
        }

        //2-) Validar que no exista otra cita con el doctor a la misma hora
        boolean existeCita = citaRepository.existsByDoctorIdAndFechaAndHora(doctorId, fecha, hora);

        if (existeCita) {
            throw new IllegalArgumentException("La hora indicada ya está ocupada");
        }

        //3-) Generar la cita y guardar
        Cita nuevaCita = Cita.builder()
                .doctor(doctorRepository.findById(doctorId).get())
                .paciente(pacienteRepository.findById(pacienteId).get())
                .fecha(fecha)
                .hora(hora)
                .build();

        return nuevaCita;
    }


}