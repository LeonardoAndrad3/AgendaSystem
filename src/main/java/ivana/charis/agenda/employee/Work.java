package ivana.charis.agenda.employee;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

@Embeddable
public enum Work {

    ESTETICISTA,
    MANICURE,
    CABELEILEREIRA,
    LASH_DESIGNER

}
