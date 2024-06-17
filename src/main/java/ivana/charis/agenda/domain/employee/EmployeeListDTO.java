package ivana.charis.agenda.domain.employee;

public record EmployeeListDTO(
        Long id,
        String name,
        String description,
        Work work
) {

    public EmployeeListDTO(Employee data) {
        this(data.getId(), data.getName(), data.getDescription(), data.getWork());
    }
}
