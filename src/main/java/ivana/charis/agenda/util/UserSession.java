package ivana.charis.agenda.util;

import ivana.charis.agenda.domain.user.UserLogin;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public abstract class UserSession {

    private static UserLogin user;

    public UserSession(HttpSession session) {
        user = getUser(session);
    }

    public static UserLogin getUser(HttpSession session){
        user = (UserLogin) session.getAttribute("user");
        return user;
    }

    public static String getRole(){
        return  user.getRole();
    }

}
