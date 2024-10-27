package generation.rencapp.api;

import com.google.api.Http;
import generation.rencapp.models.Agendamiento;
import generation.rencapp.services.AgendamientoServiceImpl;
//import generation.rencapp.services.NotificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//Anotaciones
@RestController
@RequestMapping("/api/agendamientos")
public class AgendamientoRestController {

    /** INYECCIÓN DE DEPENDENCIAS **/
    @Autowired
    private AgendamientoServiceImpl agendamientoService;

  //  @Autowired
   // private NotificacionService notificacionService;




    /** GENERAR NUEVA CITA CON EL ID DEL FUNCIONARIO Y EL ID DEL VECINO **/
    //Método post para generar la nueva cita
    @PostMapping("/{usuarioId}")
    public ResponseEntity<Agendamiento> agendar(@PathVariable Long funcionarioId,
                                            @PathVariable Long vecinoId,
                                            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd-HH:mm") LocalDateTime fechaHora) {
                                         //   @RequestParam @DateTimeFormat(pattern = "HH:mm") LocalTime hora ) {

        //Llamado al servicio de envío de mail
        Agendamiento nuevoAgendamiento = agendamientoService.agendar(funcionarioId, vecinoId, fechaHora);


       /* //Creacion de las notificaciones para funcionario y vecino
        notificacionService.crearNotificacion(
                nuevoAgendamiento.getVecino(), "Tu cita ha sido agendada para el dia y hora: " +
                        nuevoAgendamiento.getFechaHora());

        notificacionService.crearNotificacion((
                nuevoAgendamiento.getFuncionario()), "Tienes una nueva cita con " +
                nuevoAgendamiento.getVecino().getNombre() + " para el dia y hora: " + nuevoAgendamiento.getFechaHora());
*/


        return new ResponseEntity<>(agendamientoService.agendar(funcionarioId, vecinoId, fechaHora), HttpStatus.OK);

    }

    //metodo get para mostrar agendamiento por id
    @GetMapping("/{agendamientoId}/")
    public ResponseEntity<Agendamiento> verPorID(@PathVariable Long agendamientoId) {
        return new ResponseEntity<>(agendamientoService.findById(agendamientoId), HttpStatus.OK);
    }


    //metodo get
    @GetMapping("/{agendamientoId}/suspender")
    public ResponseEntity<Agendamiento> suspenderPorID(@PathVariable Long agendamientoId) {
        return new ResponseEntity<>(agendamientoService.suspenderAgendamiento(agendamientoId), HttpStatus.OK);
    }

    @GetMapping("/{vecinoId}/ver")
    public ResponseEntity<List<Agendamiento>> verAgendamientosPorVecino(@PathVariable LocalDateTime fechaHora, @PathVariable Long vecinoId){
        return new ResponseEntity<>(agendamientoService.agendamientosbyVecinoId(fechaHora, vecinoId), HttpStatus.OK);
    }

    @GetMapping("/{tramiteId}/veragendamientos")
    public ResponseEntity<List<Agendamiento>> verAgendamientosPorTramite(@PathVariable LocalDateTime fechaHora, @PathVariable Long tramiteId){
        return new ResponseEntity<>(agendamientoService.agendamientosbyTramiteId(fechaHora, tramiteId), HttpStatus.OK);
    }
}
