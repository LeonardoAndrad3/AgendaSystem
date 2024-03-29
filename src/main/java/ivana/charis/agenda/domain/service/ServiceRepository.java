package ivana.charis.agenda.domain.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

    @Query("SELECT s.start,s.ending FROM Service s where extract(date from s.start) = :day and s.employee.id = :id")
    List<ServiceTimeToWork> findByDayAndEmployee(LocalDate day, long id);
}
