package ivana.charis.agenda.infra.exceptions;

public record bodyException(
        String message,
        String... errors
) {


}
