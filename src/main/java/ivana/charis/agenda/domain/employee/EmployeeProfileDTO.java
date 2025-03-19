package ivana.charis.agenda.domain.employee;

public record EmployeeProfileDTO(
        String name,
        String email,
        Work work
) {

    public EmployeeProfileDTO(Employee data){this(data.getName(), data.getEmail(),data.getWork());}

}
