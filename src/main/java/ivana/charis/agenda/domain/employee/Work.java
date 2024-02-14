package ivana.charis.agenda.domain.employee;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

@Embeddable
public enum Work {

    ESTETICISTA,
    MANICURE,
    CABELEILEREIRA,
    LASH_DESIGNER

}
