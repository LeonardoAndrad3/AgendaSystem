package ivana.charis.agenda.domain.employee;

public record ListEmployeeDTO(
        Long id,
        String name,
        String description,
        Work work
) {

    public ListEmployeeDTO(Employee data) {
        this(data.getId(), data.getName(), data.getDescription(), data.getWork());
    }
}
