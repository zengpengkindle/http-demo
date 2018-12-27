package cn.itcast.intercepter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Created by netman on 2018/12/27.
 */
public class LoginInterceptor implements HandlerInterceptor {



    //@Autowired
    //DataSource dataSource; //如果需要

    private  Logger loggerFactory=LoggerFactory.getLogger(this.getClass());
    @Override
   public   boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        loggerFactory.debug("this is preHandle of new");
        return true;
    }
    @Override
    public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        loggerFactory.debug("this is postHandle of new");
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        loggerFactory.debug("this is afterCompletion of new");
    }
}
