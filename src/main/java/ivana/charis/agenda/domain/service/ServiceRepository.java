package ivana.charis.agenda.domain.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {


    Page<ServiceListDTO> findAllById(Pageable pg, Long id);

    @Query("SELECT new ivana.charis.agenda.domain.service.ServiceTimeToWork(s.start,s.ending) FROM Service s where s.date = :day and s.employee.id = :id")
    List<ServiceTimeToWork> findByDayAndEmployee(LocalDate day, long id);

//    @Query("SELECT s from Service s where s.status")
//    List<Service> findByServicesFinishState();
}
