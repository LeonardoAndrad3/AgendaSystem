package ivana.charis.agenda.domain.employee;

import jdk.jfr.BooleanFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    UserDetails findByEmail (String email);

    @Query("""
            select case when count(e) = 0 then true else false end from Employee e
            join e.services s
            where s.employee.id = :id
            and
            s.start in( 
                select start from Service s
                where
                s.start > :start
                and
                s.start < :ending
            )
            or 
            s.ending in(            
                select ending from Service s
                where
                s.ending > :start
                and
                s.ending < :ending          
            )
            """)
    boolean findAgendaMarked(LocalDateTime start, LocalDateTime ending, Long id);

}
