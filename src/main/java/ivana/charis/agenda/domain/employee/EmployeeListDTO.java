package ivana.charis.agenda.domain.employee;

public record EmployeeListDTO(
        Long id,
        String name
) {

    public EmployeeListDTO(Employee data) {
        this(data.getId(), data.getName());
    }
}
