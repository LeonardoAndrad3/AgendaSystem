package ivana.charis.agenda.domain.employee;

public record EmployeeProfileDTO(
        String name,
        Work work
) {

    public EmployeeProfileDTO(Employee data){this(data.getName(), data.getWork());}

}
