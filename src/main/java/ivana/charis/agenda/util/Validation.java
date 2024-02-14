package ivana.charis.agenda.util;


import java.lang.reflect.Field;

public class Validation {
    public  static <T> boolean  notNull(T obj){
        return (obj != null || obj.toString().trim().equalsIgnoreCase("") || obj instanceof Integer && (Integer) obj == 0);
    }
}
