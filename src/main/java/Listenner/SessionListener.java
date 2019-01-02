package Listenner;

import entity.User;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Map;

/**
 * @author yangxin
 * @time 2019/1/2  10:09
 */
public class SessionListener  implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            ServletContext application = session.getServletContext();
            @SuppressWarnings("unchecked")
            Map<Integer, Object> loginMap = (Map<Integer, Object>) application.getAttribute("loginMap");
            loginMap.remove(user.getUserId());
            application.setAttribute("loginMap", loginMap);
            session.removeAttribute("user");
        }
    }
}
