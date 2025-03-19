package ivana.charis.agenda.auth;

import ivana.charis.agenda.domain.employee.Work;

public record User(Long id, String name, String email, Work work, String role) {
}
