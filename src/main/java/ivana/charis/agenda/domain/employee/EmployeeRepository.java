package ivana.charis.agenda.domain.employee;

import ivana.charis.agenda.domain.user.UserLogin;
import jdk.jfr.BooleanFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmail (String email);

    @Query("""
            select case when count(e) = 0 then true else false end
            from Employee e
                        join e.services s
                        where e.id = :id
                        and
                        s.date = :date
                        and
                        s.start in(
                            select start from Service s
                            where
                            s.date = :date
                            and
                            s.start >= :start
                            and
                            s.start <= :ending
                        )
                        or
                        s.ending in(
                            select ending from Service s
                            where
                            s.date = :date
                            and
                            s.ending >= :start
                            and
                            s.ending <= :ending
            )
            """)
    boolean findAgendaMarked(LocalDate date, LocalTime start, LocalTime ending, Long id);

}
