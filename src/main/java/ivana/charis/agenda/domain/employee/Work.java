package ivana.charis.agenda.domain.employee;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;

public enum Work {

    ESTETICISTA("esteticista"),
    MANICURE("manicure"),
    CABELEIRERA("cabeleirera"),
    LASH_DESIGNER("lashDesigner");

    private String work;

    Work(String work){
        this.work = work;
    }


}
