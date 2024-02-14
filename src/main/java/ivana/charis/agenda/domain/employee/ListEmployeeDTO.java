package ivana.charis.agenda.domain.employee;

public record ListEmployeeDTO(
        Long id,
        String name,
        String email,
        String description,
        String photo,
        Work work
) {

    public ListEmployeeDTO(Employee data) {
        this(data.getId(), data.getName(), data.getEmail(), data.getDescription(), data.getPhone(), data.getWork());
    }
}
