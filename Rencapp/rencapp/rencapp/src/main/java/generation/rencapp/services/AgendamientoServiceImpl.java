package generation.rencapp.services;

import generation.rencapp.models.TipoUsuario;
import generation.rencapp.repositories.AgendamientoRepository;
import generation.rencapp.repositories.UsuarioRepository;
import generation.rencapp.repositories.VecinoRepository;
import generation.rencapp.models.Agendamiento;
import generation.rencapp.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

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
    @Autowired
    private UsuarioRepository usuarioRepository;


    //Método para agendar cita
    @Override
    public Agendamiento agendar( Long usuarioId, LocalDateTime fechaHora) {
        //1-) Validar si la hora esta contenida dentro del intervalo y guardamos el resultado en una variable
       /* boolean esValido = horarioServiceImpl.validarAgendamientoDentroDelHorario(usuarioId, fechaHora);

        if (!esValido) {
            throw new IllegalArgumentException("La hora indicada no está disponible");
        }

        //2-) Validar que no exista otra cita con el doctor a la misma hora
        boolean existeAgendamiento = agendamientoRepository.existsByFechaHoraAndUsuarioId(fechaHora, usuarioId);

        if (existeAgendamiento) {
            throw new IllegalArgumentException("La hora indicada ya está ocupada");
        }
*/
        //3-) Generar la cita y guardar
        Agendamiento nuevoAgendamiento = Agendamiento.builder()
                .usuario(usuarioRepository.findById(usuarioId).get())
                .fechaHora(fechaHora)
                .build();

        agendamientoRepository.save(nuevoAgendamiento);

        return nuevoAgendamiento;
    }

    public Agendamiento buscarPorId(Long agendamientoId) {
        return agendamientoRepository.findById(agendamientoId).get();
    }

   public Agendamiento suspenderAgendamiento(Long agendamientoId) {
        Agendamiento agendamientoSeleccionado = agendamientoRepository.findById(agendamientoId).get();
        agendamientoSeleccionado.setEstado(Agendamiento.estadoAgendamiento.CANCELADA);
        return agendamientoRepository.save(agendamientoSeleccionado);
   }

   public List<Agendamiento> agendamientosbyVecinoId(Long usuarioId, String tipo) {
       TipoUsuario usuarioTipo = TipoUsuario.valueOf(tipo);
        return agendamientoRepository.findAllByUsuarioIdAndUsuarioTipo(usuarioId, usuarioTipo);
   }

    public List<Agendamiento> agendamientosbyTramiteId(Long tramiteId) {
        return agendamientoRepository.findAllByTramiteId(tramiteId);
    }

}