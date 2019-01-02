package filter;

import entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author yangxin
 * @time 2019/1/2  13:46
 */
@WebFilter
public class LoginFilter implements Filter {
    Logger log = LoggerFactory.getLogger(LoginFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("进入过滤器处理");
        HttpServletRequest httpRequest =(HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        String uri = httpRequest.getRequestURI();
        if(uri.contains("login")||uri.contains("register")||uri.contains("AdminLogin")){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            User user =(User) httpRequest.getSession().getAttribute("user");
            if(null==user){
                httpResponse.sendRedirect("login.jsp");
            }else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
