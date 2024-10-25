package generation.rencapp.repositories;

import generation.rencapp.models.Agendamiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository

public interface AgendamientoRepository extends JpaRepository<Agendamiento, Long> {

    boolean existsByFuncionarioIdAndFechaAndHora(Long funcionarioId, LocalDate fecha, LocalTime hora);

    //Crear métodos que trabajen con querys nativas, con SQL
    /**@Query(value = "select * from citas c where c.doctor_id = 1?", nativeQuery = true)
     @Query(value = "select * from citas c where c.doctor_id = :doctorId and c.fecha = :fecha", nativeQuery = true)
     List<Cita> findAllCitaByDoctorId(@Param("doctorId") Long doctorId, @Param("fecha") LocalDate fecha);**/

    //JPQL

    List<Agendamiento> findAllByFechaHoraAndVecinoId(LocalDateTime fechaHora, Long vecinoId);

    List<Agendamiento> findAllByFechaHoraAndTramiteId(LocalDateTime fechaHora, Long tramiteId);




}

