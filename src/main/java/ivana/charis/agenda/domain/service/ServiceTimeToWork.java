package ivana.charis.agenda.domain.service;

import java.time.LocalTime;

public record ServiceTimeToWork(LocalTime start, LocalTime ending) {
}
