package ivana.charis.agenda.infra;

public record bodyException(
        String message,
        String... errors
) {


}
